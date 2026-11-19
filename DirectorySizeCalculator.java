import java.io.File;
import java.util.HashSet;
class DirectorySizeCalculator{
    static long calculate(File folder,HashSet<String> visited){
        try{
            String path=folder.getCanonicalPath();
            if(!visited.add(path))
                return 0;
            if(folder.isFile())
                return folder.length();
            long total=0;
            File[] files=folder.listFiles();
            if(files!=null){
                for(File f:files)
                    total+=calculate(f,visited);
            }
            return total;
        }
        catch(Exception e){
            return 0;
        }
    }
    public static void main(String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path=sc.nextLine();
        File folder=new File(path);
        if(!folder.exists()||!folder.isDirectory()){
            System.out.println("Invalid directory");
            return;
        }
        long size=calculate(folder,new HashSet<String>());
        System.out.println("Total size: "+size+" bytes");
        System.out.println("Total size: "+(size/1024.0)+" KB");
    }
}