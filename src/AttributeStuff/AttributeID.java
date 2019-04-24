package AttributeStuff;

/**
 * @author Jasen Harper
 * Represents any attribute of a character
 */
public class AttributeID{

    private String attributeType = "/";
    private String name = "/";
    private String alignment = "/";
    private String sex = "/";
    private String size = "/";

    public AttributeID(String raceName, String raceAlignment, String raceSex, String raceSize){
        this.attributeType = "Race";
        this.name = raceName;
        this.alignment = raceAlignment;
        this.sex = raceSex;
        this.size = raceSize;
    }

    public AttributeID(String className, String classAlignment){
        this.attributeType = "Class";
        this.name = className;
        this.alignment = classAlignment;
    }

    public AttributeID(String[] custom){
        //Format: 0 = type, 1 = name
        this.attributeType = custom[0];
        this.name = custom[1];
    }

    public String getAttributeType(){
        return attributeType;
    }

    public String getName(){
        return name;
    }

    public String getAlignment(){
        return alignment;
    }

    public String getSex(){
        return sex;
    }

    public String getSize(){
        return size;
    }

}
