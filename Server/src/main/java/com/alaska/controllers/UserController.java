package com.alaska.controllers;

import com.alaska.daos.MySqlUserDao;
import com.alaska.daos.UserDao;
import com.alaska.models.User;
import com.alaska.utils.InvalidUserLoginException;
import com.alaska.utils.UserExistsException;

import java.util.ArrayList;

//the following imports are for the hashing funcitons
import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
//

public class UserController{
    private UserDao dao;
    
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    // The following constants may be changed without breaking existing hashes.
    public static final int SALT_BYTE_SIZE = 32;
    public static final int HASH_BYTE_SIZE = 32;
    public static final int PBKDF2_ITERATIONS = 1000;
    //

    public static final int ITERATION_INDEX = 0;
    public static final int SALT_INDEX = 1;
    public static final int PBKDF2_INDEX = 2;

    public UserController() {
        dao = new MySqlUserDao();
    }

    public User createUser(User user) throws UserExistsException{
        ArrayList<User> users = dao.readUsers();
	
	//User dbUser = dao.readUser(user);
	//if (dbUser != null) throw new UserExistsException();
	//or does this create a sql error if the user doesn't exist?
		
	for (User u : users){
		if (user.getEmail().equals(u.getEmail())){
                	throw new UserExistsException();
            	}
	}
	user.setPassword(createHash(user.getPassword()));//hoping the setPassword function exists, didn't have time to check right now
        dao.createUser(user);
        return user;
    }

    public String validateUser(User user) throws InvalidUserLoginException{
        User dbUser = dao.readUser(user);
        if(validatePassword(user.getPassword(), dbUser.getPassword())){//dbUser.getPassword needs to return the hash built by this classes createHash function
            String token = "valid";
            return token;
        }else{
            throw new  InvalidUserLoginException();
        }
    }
    
    public static String createHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        return createHash(password.toCharArray());
    }
    public static String createHash(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);

        // Hash the password
        byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
        // format iterations:salt:hash
        return PBKDF2_ITERATIONS + ":" + toHex(salt) + ":" +  toHex(hash);
    }
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException{
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }
    public static boolean validatePassword(String password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException{
        return validatePassword(password.toCharArray(), correctHash);
    }
    public static boolean validatePassword(char[] password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException{
        // Decode the hash into its parameters
        String[] params = correctHash.split(":");
        int iterations = Integer.parseInt(params[ITERATION_INDEX]);
        byte[] salt = fromHex(params[SALT_INDEX]);
        byte[] hash = fromHex(params[PBKDF2_INDEX]);
        // Compute the hash of the provided password, using the same salt, 
        // iteration count, and hash length
        byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
        // Compare the hashes in constant time. The password is correct if
        // both hashes match.
        return slowEquals(hash, testHash);
    }
    private static boolean slowEquals(byte[] a, byte[] b){
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }
    private static byte[] fromHex(String hex){
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++){
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }
    private static String toHex(byte[] array){
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
}
