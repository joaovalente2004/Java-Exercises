public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager();


           // fileManager.login("admin", "123");

        try {
            fileManager.login("admin", "123");
            fileManager.createFile("file.txt");
            fileManager.getFile("file.txt");
            fileManager.logout();
        } catch (FileException e) {
            System.out.println(e.getMessage());

        }






    }
}
