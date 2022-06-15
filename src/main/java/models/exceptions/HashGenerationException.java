package models.exceptions;

public class HashGenerationException extends Exception{
    public HashGenerationException() {
        super("Could not generate hash from String");
    }
}
