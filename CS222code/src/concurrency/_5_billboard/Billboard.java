package concurrency._5_billboard;

class Billboard {
    final int LENGTH = 12;
    char[] signs = new char[LENGTH];

    public void write(String message) throws InterruptedException {
        if (message.length() != signs.length) {
            throw new IllegalArgumentException("Message length has to be " + signs.length);
        }
        for(int i = 0; i < signs.length; i++) {
            Thread.sleep(10); // It takes some time to put the sign
            signs[i] = message.charAt(i);
        }
    }

    public String read() throws InterruptedException {
        String message = "";
        for(int i = 0; i < signs.length; i++) {
            Thread.sleep(2); // It takes some time to read the sign
            message += signs[i];
        }
        return message;
    }
}
