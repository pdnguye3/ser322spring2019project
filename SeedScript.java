/**
 * SeedScript. Generates MySQL tuples.
 * 
 * @author Phillip Nguyen, Kai Wood, Kevin Hale
 * @version 15.April.2019
 */
public class SQLGenerator {
    final static String INSERT = "INSERT ", INTO = "INTO ", VALUES = " VALUES ", SEPARATOR = ", ";
    
    public static void main(String[] args) {
        String[] publishers, developers, requirements;
        
        publishers = populateTableType1(5, 0, "publisher");
        developers = populateTableType1(5, 0, "developer");
        
        requirements = populateTableType2(5, 0, "requirements");
        
        printAll(publishers);
        printAll(developers);
        printAll(requirements);
    }
    
    static void printAll(String[] in) {
        for(String e : in)
            System.out.println(e);

        System.out.println("--------");
    }
    
    static String[] populateTableType1(int num, int start, String tableName) {
        String[] out = new String[num];
        String name = "Name", address = "Address", phoneNum = "5555555555";
        
        if(start < 0) {
            System.out.println("Erroneous start index! Please enter a non-negative integer.");
            
            return out;
        }
        
        for(int i = start ; i < (num + start) ; i ++) {
            phoneNum = phoneNum.substring(0, 10 - ((int) (Math.log10(i == 0 ? 1 : i) + 1))) + i;
            out[i - start] = INSERT + INTO + tableName + VALUES + "("
                    + name + i + SEPARATOR + address + i + SEPARATOR + phoneNum + ");";
        }
        
        return out;
    }
    
    static String[] populateTableType2(int num, int start, String tableName) {
        String[] out = new String[num];
        String processor = "Processor", platform = "PC", RAM = "8", graphics = "Graphics", disk = "25GB";
        
        if(start < 0) {
            System.out.println("Erroneous start index! Please enter a non-negative integer.");
            
            return out;
        }
        
        for(int i = start ; i < (num + start) ; i ++) {
            out[i - start] = INSERT + INTO + tableName + VALUES + "("
                    + i + SEPARATOR + processor + i + SEPARATOR + platform
                    + SEPARATOR + RAM + SEPARATOR + graphics + i + SEPARATOR + disk + ");";
        }
        
        return out;
    }
    
}
