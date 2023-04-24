

/**
 * Lesson_2
 */
public class Lesson_2 {

    public static void main(String[] args) {
        /*
         * 1) Дана строка sql-запроса "select * from students where ". 
         * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
         * Данные для фильтрации приведены ниже в виде json-строки.

Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */


         StringBuilder text = new StringBuilder("select * from students where ");
         String textWhere = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
         String newTextWhere = textWhere.replace('{', ' ');
         newTextWhere = newTextWhere.replace('}', ' ');
         newTextWhere = newTextWhere.replace('"', ' ');
         newTextWhere = newTextWhere.replace(' ', '\0');
         String [] resultText = newTextWhere.split(",");
         String endResultText = text.toString(); 
         for (int i = 0; i < resultText.length; i++) {
            String []partOfResultText = resultText[i].split(":");
            
            if (!partOfResultText[1].equals("null"))
            {
                endResultText = endResultText + partOfResultText[0] + " " + "=" + " " + partOfResultText[1] + " " + "AND" + " ";
            }
            else
            {
                continue;
            }
         }
         endResultText = endResultText.substring(0, endResultText.length()-4);
         System.out.println(endResultText);
        


    }
}