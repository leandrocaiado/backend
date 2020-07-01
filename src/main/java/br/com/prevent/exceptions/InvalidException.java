package br.com.prevent.exceptions;

public class InvalidException extends Exception {
   private static final long serialVersionUID = 4267037201695008417L;
   private Object[] args = new Object[4];

   public InvalidException() {
   }

   public InvalidException(String message) {
      super(message);
   }

   public InvalidException(String message, Object arg0) {
      super(message);
      this.args[0] = arg0;
   }

   public InvalidException(String message, Object arg0, Object arg1) {
      super(message);
      this.args[0] = arg0;
      this.args[1] = arg1;
   }

   public InvalidException(String message, Object arg0, Object arg1, Object arg2) {
      super(message);
      this.args[0] = arg0;
      this.args[1] = arg1;
      this.args[2] = arg2;
   }

   public InvalidException(String message, Object arg0, Object arg1, Object arg2, Object arg3) {
      super(message);
      this.args[0] = arg0;
      this.args[1] = arg1;
      this.args[2] = arg2;
      this.args[3] = arg3;
   }

   public InvalidException(String message, Throwable cause) {
      super(message, cause);
   }

   public InvalidException(Throwable cause) {
      super(cause);
   }

   public Object[] getArgs() {
      return this.args;
   }

   public void setArgs(Object[] args) {
      this.args = args;
   }
}