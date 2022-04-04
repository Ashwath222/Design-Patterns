package dp;

import java.util.ArrayList;
import java.util.List;

public class CodeBuilder {

    protected String className;
    List<Field> fields = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String string) {
        this.fields.add(new Field(name, string));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("public class %s\n", this.className));
        sb.append("{\n");
        for (Field field : fields) {
            sb.append(String.format("  public %s %s;\n", field.string, field.name));
        }
        sb.append("}");
        return sb.toString();
    }
}

class Field {
    public String name, string;

    public Field(String name, String string) {
        this.name = name;
        this.string = string;
    }
}

class test {
    public static void main(String[] args) {
        CodeBuilder cd = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cd);

    }
}
