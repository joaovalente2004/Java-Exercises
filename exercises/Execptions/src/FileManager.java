public class FileManager {

    private String username = "admin";
    private String password = "123";



    private boolean statusLogin = false;




    public void login( String username, String password) throws NotEnoughPermissionsException {
        if (username.equals(this.username) && password.equals(this.password)) {
            System.out.println("Login successful");
            statusLogin = true;
        }
        else {
            throw new NotEnoughPermissionsException();
        }


    }
    public void logout() {

        statusLogin = false;
        System.out.println("Logout successful");

    }
    public File getFile(String filename) throws FileNotFoundException {

        if (filename.equals("file.txt")) {
            System.out.println("File.txt found");
            return new File();
        }
        else {
            throw new FileNotFoundException();
        }


    }
    public void createFile(String createfile) throws NotEnoughSpaceException {


        File [] files = new File[1];

        if (statusLogin == true) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == null) {
                    files[i] = new File();
                    files[i].getName(createfile);
                    System.out.println("File created: " + createfile);
                    break;
                }
                else {
                    throw new NotEnoughSpaceException();
                }
            }
        }
           else {
            System.out.println("You are not logged in");
            }


    }



}
