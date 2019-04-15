import java.util.Scanner;

/**
 * SeedScript. Generates sample MySQL tuples based on input amount.
 * 
 * @author Phillip Nguyen, Kai Wood, Kevin Hale
 * @version 15.April.2019
 */
public class SeedScript {
    final static String INSERT = "INSERT ", INTO = "INTO ", VALUES = " VALUES ", SEPARATOR = ", ", APOSTROPHE = "'";
    
    public static void main(String[] args) {
        //Tables are organized by heirarchy, where preceding tables provide
        //foreign keys in their respective heirarcy.
        String[] publishers, developers, requirements;
        String[] games;
        String[] players, seasonpasses, dlcs;
        
        String[] manufacturers;
        String[] keyboards, controllers, mouses;
        
        String[] specs;
        String[] computers, consoles;
        
        String[] launcher;
        
        int num = 0;
        boolean valid = false;
        Scanner num_reader = new Scanner(System.in);
        do {
            System.out.print("Input number of test tuples to be generated for each table: ");
            if(num_reader.hasNextInt()) {
                num = num_reader.nextInt();
                valid = true;
            } else {
                num_reader.next();
            }
        } while(!valid);
        System.out.println();
        
        publishers = populateTableType1(num, "publisher");
        developers = populateTableType1(num, "developer");
        requirements = populateTableType2(num, "requirements");
        games = populateTableType3(num, "game");
        
        printAll(publishers);
        printAll(developers);
        printAll(requirements);
        printAll(games);
    }
    
    static void printAll(String[] in) {
        for(String e : in)
            System.out.println(e);

        System.out.println("--------");
    }
    
    static String[] populateTableType1(int num, String tableName) {
        String[] out = new String[num];
        
        if(num < 1) {
            System.out.println("Less than 1 tuples requested. Nothing produced.");
            return out;
        }
        
        boolean isValid = false;
        String[] validTableNames = new String[] {"publisher", "developer"};
        for(String name : validTableNames)
            if(tableName.equals(name))
                isValid = true;
        
        if(!isValid) {
            System.out.println("Invalid tableName! Input must be an accepted value and all lowercase.");
            return out;
        }
        
        String name = "Name", address = "Address", phoneNum = "5555555555";
        for(int i = 0 ; i < num ; i++) {
            //fixes the number of digits in phoneNum
            phoneNum = phoneNum.substring(0, 10 - ((int) (Math.log10(i == 0 ? 1 : i) + 1))) + i;
            
            out[i] = INSERT + INTO + tableName + VALUES + "("
                    + APOSTROPHE + name + i + APOSTROPHE + SEPARATOR + APOSTROPHE + address + i + APOSTROPHE + SEPARATOR + APOSTROPHE + phoneNum + APOSTROPHE + ");";
        }
        
        return out;
    }
    
    static String[] populateTableType2(int num, String tableName) {
        String[] out = new String[num];
        
        if(num < 1) {
            System.out.println("Less than 1 tuples requested. Nothing produced.");
            return out;
        }
        
        boolean isValid = false;
        String[] validTableNames = new String[] {"requirements"};
        for(String name : validTableNames)
            if(tableName.equals(name))
                isValid = true;
        
        if(!isValid) {
            System.out.println("Invalid tableName! Input must be an accepted value and all lowercase.");
        }
        
        String processor = "Processor", platform = "PC", RAM = "8", graphics = "Graphics", disk = "25GB";
        for(int i = 0 ; i < num ; i++) {
            out[i] = INSERT + INTO + tableName + VALUES + "("
                    + i + SEPARATOR + APOSTROPHE + processor + i + APOSTROPHE + SEPARATOR + APOSTROPHE + platform + APOSTROPHE + SEPARATOR
                    + RAM + SEPARATOR + APOSTROPHE + graphics + i + APOSTROPHE + SEPARATOR + APOSTROPHE + disk + APOSTROPHE + ");";
        }
        return out;
    }
    
    static String[] populateTableType3(int num, String tableName) {
        String[] out = new String[num];
        
        if(num < 1) {
            System.out.println("Less than 1 tuples requested. Nothing produced.");
            return out;
        }
        
        boolean isValid = false;
        String[] validTableNames = new String[] {"game"};
        for(String name : validTableNames)
            if(tableName.equals(name))
                isValid = true;
        
        if(!isValid) {
            System.out.println("Invalid tableName! Input must be an accepted value and all lowercase.");
        }
        
        String title = "Game Title ", publisherName = "Publisher", developerName = "Developer",
                rating = "Teen", cost = "60.00", difficulty = "Beginner", ageRating = "12+", 
                genre = "Indie", platformName = "PC";
        for(int i = 0 ; i < num ; i++) {
            out[i] = INSERT + INTO + tableName + VALUES + "("
                    + APOSTROPHE + title + i + APOSTROPHE + SEPARATOR + APOSTROPHE + publisherName + i + APOSTROPHE + SEPARATOR + APOSTROPHE + developerName + i + APOSTROPHE + SEPARATOR
                    + APOSTROPHE + rating + APOSTROPHE + SEPARATOR + i + SEPARATOR + cost + SEPARATOR
                    + APOSTROPHE + difficulty + APOSTROPHE + SEPARATOR + APOSTROPHE + ageRating + APOSTROPHE + SEPARATOR + APOSTROPHE + genre + APOSTROPHE + SEPARATOR
                    + APOSTROPHE + platformName + APOSTROPHE + ");";
        }
        return out;
    }
}
