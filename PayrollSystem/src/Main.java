import java.util.Arrays;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR,1959);
        instance.set(Calendar.MONTH,2);
        instance.set(Calendar.DATE,23);

        Staff staff = new Staff("123","Allen","Paita","M",instance,50);

        instance.set(Calendar.YEAR,1964);
        instance.set(Calendar.MONTH,7);
        instance.set(Calendar.DATE,12);
        Staff staff2 = new Staff("456","Zapata","Steven","F",instance,35);

        instance.set(Calendar.YEAR,1970);
        instance.set(Calendar.MONTH,6);
        instance.set(Calendar.DATE,2);
        Staff staff3 = new Staff("789","Rios","Enrique","M",instance,40);

        instance.set(Calendar.YEAR,1962);
        instance.set(Calendar.MONTH,4);
        instance.set(Calendar.DATE,27);

        Education education = new Education("Ph.D","Engineering",3);
        Faculty.Level level = Faculty.Level.FU;
        Faculty faculty = new Faculty("243","Jonson","Anne","F",instance,education,level);


        education = new Education("Ph.D","English",1);
        instance.set(Calendar.YEAR,1975);
        instance.set(Calendar.MONTH,3);
        instance.set(Calendar.DATE,14);
        level = Faculty.Level.AO;
        Faculty faculty1 = new Faculty("791","Bouris","William","F",instance,education,level);


        education = new Education("MS","PhysicalEducation",0);
        instance.set(Calendar.YEAR,1980);
        instance.set(Calendar.MONTH,5);
        instance.set(Calendar.DATE,22);
        level = Faculty.Level.AS;
        Faculty faculty2 = new Faculty("623","Andrade","Christopher","F",instance,education,level);

        instance.set(Calendar.YEAR,1977);
        instance.set(Calendar.MONTH,8);
        instance.set(Calendar.DATE,10);
        Parttime partTime = new Parttime("455","Guzman","Augusto","M",instance,30,35);

        instance.set(Calendar.YEAR,1987);
        instance.set(Calendar.MONTH,9);
        instance.set(Calendar.DATE,15);
        Parttime partTime1 = new Parttime("678","Depiro","Martin","F",instance,15,30);

        instance.set(Calendar.YEAR,1988);
        instance.set(Calendar.MONTH,11);
        instance.set(Calendar.DATE,24);
        Parttime partTime2 = new Parttime("945","Aldaco","Marque","M",instance,35,20);

        Employee[] array = {
            staff,
            staff2,
            staff3,
            faculty,
            faculty1,
            faculty2,
            partTime,
            partTime1,
            partTime2
        };

        /*
        System.out.println();
        System.out.println(array[3].lastName);


        System.out.println();
*/
        /*
        StringBuilder stb = new StringBuilder();
        StringBuilder name = stb.append(staff).append(2);


        //一つ目の文字列
        String str1 = "さしすせそ";
        System.out.println(str1);

        //二つ目の文字列
        String str2 = "たちつてと";
        System.out.println(str2);

        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(str2);

        System.out.println("Name---"+sb);
*/
        //a. Display employee information using toString method
       /*
        for(int i=0;i<9;i++){
         //   System.out.println(array[i].toString());StringBuilder stb = new StringBuilder();
            System.out.println("\nNo."+(i+1)+"\n"+array[i].toString()+"\n");
        }*/

        // b. total monthly salary for all part-time staff
        /*
        double total = 0;
        for(int i=6;i<9;i++)
            total += array[i].monthlyEarning();
        System.out.println("\nTotal monthly salary for all part-time staff is: " + total);
        */

        // c. total month salary for all employees.
        /*double total = 0;
        for(int i=0;i<9;i++)
            total += array[i].monthlyEarning();
        System.out.println("Total month salary for all employees is : " + total);*/

        // d. sort the employee and then display employee information
        /*int[] integers1 = new int[10];
        for(int i=0;i<9;i++){
            int integers = Integer.parseInt(array[i].IdNumber);
            integers1[i] = integers;
        }


        Arrays.sort(integers1);
        for(int k=0; k<9; k++){
            String name = String.valueOf(integers1[k]);

            for(int t=0; t<9; t++){
                if(array[t].IdNumber.equals(name)){
                    System.out.println("\nNo."+(k+1)+"\n"+array[t].toString()+"\n");
                }
            }

        }*/

        /*
        String[] strings = new String[10];
        for(int i=0;i<9;i++){
            String s = array[i].lastName;
            strings[i] =s;
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        };

        Arrays.sort(strings,comparator);

        for(int i=0;i<9;i++){
            String name = String.valueOf(strings[i]);

            for(int t=0; t<9; t++){
                if(array[t].lastName.equals(name)){
                    System.out.println("\nNo."+(i+1)+"\n"+array[t].toString()+"\n");
                }
            }
        }*/

        // f. Duplicate a faculty
        education = new Education("MS","PhysicalEducation",0);
        instance.set(Calendar.YEAR,1980);
        instance.set(Calendar.MONTH,5);
        instance.set(Calendar.DATE,22);
        level = Faculty.Level.AS;

        Employee faculty4 =new Faculty("623","Andrade","Christopher","F",instance,education,level);;
        Employee duplicateFaculty = (Faculty)((Faculty)faculty4).duplicate();
        if(duplicateFaculty == null)
            System.out.println("Duplicate false.");
        else
            System.out.println("Duplicate faculty: " + duplicateFaculty.toString());

        for(int i=3; i<6; i++){
            for(int k=3; k<6; k++){
                if(k!=i&&array[i].IdNumber.equals(faculty4.IdNumber)){
                    System.out.println("Duplicate.");
                }
            }
        }
     }
}

interface EmployeeInfo{
    final float  FACULTY_MONTHLY_SALARY = 5000.00F;
    final int STAFF_MONTHLY_HOURS_WORKED = 160;
}

abstract class Employee implements EmployeeInfo, Comparable<Employee> {
    String lastName;
    String firstName;
    String IdNumber;
    String Sex;
    Calendar BirthDate = Calendar.getInstance();

    public Employee() {
    }

    public Employee(String employNumber, String lastName, String firstName, String Sex, Calendar Birthdate) {
        IdNumber = employNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.Sex = Sex;
        this.BirthDate.set(Calendar.YEAR, Birthdate.get(Calendar.YEAR));
        this.BirthDate.set(Calendar.MONTH, Birthdate.get(Calendar.MONTH));
        this.BirthDate.set(Calendar.DATE, Birthdate.get(Calendar.DATE));
    }

    public String getId() {
        return this.IdNumber;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String setFirstName(){
        return this.firstName;
    }

    public Calendar getBirthDate(){
        return this.BirthDate;
    }

    public void SetId(String id){
        this.IdNumber = id;
    }

    public void SetLastName(String lastName){
        this.lastName = lastName;
    }

    public void SetFristName(String firstName){
        this.firstName = firstName;
    }

    public void SetBirthday(int year, int month,int day){
        this.BirthDate.set(Calendar.YEAR,year);
        this.BirthDate.set(Calendar.MONTH,month);
        this.BirthDate.set(Calendar.MONTH,day);
    }

    public String toString() {
        return
                "ID Employee number : " + this.IdNumber +
                        "\nEmployee name : " + this.firstName + this.lastName + "" +
                        "\nBirth date : " + this.BirthDate.get(Calendar.YEAR) + "/" + this.BirthDate.get(Calendar.MONTH) + "/" + this.BirthDate.get(Calendar.DATE);
    }

    public int compareTo(Employee o) {
        if (this.IdNumber.compareTo((o.getId())) == -1)
            return 1;
        else if (this.IdNumber.compareTo(o.getId()) == 0)
            return 0;
        else
            return -1;
    }

    public abstract int monthlyEarning();

    public void SetBirthday(int month, int day) {
        this.BirthDate.set(Calendar.MONTH, month);
        this.BirthDate.set(Calendar.MONTH, day);
    }
}

class Staff extends Employee{
    int HourlyRate;

    public Staff(){
    }

    public Staff(String employNumber,String lastName, String firstName, String sex, Calendar Birthdate,int hourlyRate){
        super(employNumber,lastName, firstName,sex,Birthdate);
        this.HourlyRate = hourlyRate;
    }

    @Override
    public int monthlyEarning() {

            int num = this.HourlyRate*160;
            return num;
    }

    public String toString(){
        return
                "ID Employee number : "+this.IdNumber+
                "\nEmployee name : "+this.firstName+this.lastName+"" +
                "\nBirth date : "+this.BirthDate.get(Calendar.YEAR)+"/"+this.BirthDate.get(Calendar.MONTH)+"/"+this.BirthDate.get(Calendar.DATE)+"\nFull time Monthly Salary : "+monthlyEarning();
    }

    public void SetLastName(String lName){
        this.lastName = lName;
    }

    public void SetFirstName(String fName){
        this.firstName = fName;
    }

    public void SetBirthday(int year, int month,int day){
        this.BirthDate.set(Calendar.YEAR,year);
        this.BirthDate.set(Calendar.MONTH,month);
        this.BirthDate.set(Calendar.MONTH,day);
    }

    public void SetHourlyRate(int hourlyRate){
        this.HourlyRate = hourlyRate;
    }

    public String GetLastName(){
        return this.lastName;
    }

    public String GetFirstName(){
        return this.firstName;
    }

    public Calendar GetBirthday(){
        return this.BirthDate;
    }

    public int GetHourlyRate(){
        return this.HourlyRate;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}

class Education{
    String Degree;
    String Major;
    int Research;

    public Education(){

    }

    public Education(String Degree,String Major, int Research){
        this.Degree = Degree;
        this.Major = Major;
        this.Research = Research;
    }

    public String GetDegree(){
        return this.Degree;
    }

    public String GetMajor(){
        return this.Major;
    }

    public int GetResearch(){
        return this.Research;
    }

    public void SetDegree(String name){
        this.Degree = name;
    }

    public void SetMajor(String name){
        this.Major = name;
    }

    public void SetResearch(int name){
        this.Research = name;
    }
}

class Faculty extends Employee implements  Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Object duplicate(){
        try{
            return clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    public enum Level{
        AS,
        AO,
        FU;
    }

    Education educationObject = new Education();

    Level level;

    public Faculty(){

    }

    public Faculty(String employNumber,String lastName, String firstName,String sex, Calendar Birthdate, Education education, Level level){
        super(employNumber,lastName, firstName,sex,Birthdate);
        this.educationObject = education;
        this.level = level;
    }

    @Override
    public int monthlyEarning() {

        if (Level.AO.equals(level)) {
            return (int) (500 * 1.2);
        } else if (Level.FU.equals(level)) {
            return 500;
        } else if (Level.AS.equals(level)) {
            return (int) (500 * 1.4);
        } else {
            return 0;
        }
    }

    public void SetLastName(String lName){
        this.lastName = lName;
    }

    public void SetFirstName(String fName){
        this.firstName = fName;
    }

    public void SetBirthday(int year, int month,int day){
        this.BirthDate.set(Calendar.YEAR,year);
        this.BirthDate.set(Calendar.MONTH,month);
        this.BirthDate.set(Calendar.MONTH,day);
    }

    public String GetLastName(){
        return this.lastName;
    }

    public String GetFirstName(){
        return this.firstName;
    }

    public Calendar GetBirthday(){
        return this.BirthDate;
    }

    public String toString(){
        return
                "ID Employee number : "+this.IdNumber+
                        "\nEmployee number : "+this.firstName+this.lastName+"" +
                        "\nBirth date : "+this.BirthDate.get(Calendar.MONTH)+"/"+this.BirthDate.get(Calendar.DATE)+"\nFull time Monthly Salary : "+monthlyEarning();
    }
}

class Parttime extends Staff{
    int hoursWorkedPerWeek;

    public Parttime(){}

    public Parttime(String employNumber,String lastName, String firstName,String sex, Calendar Birthdate, int hours, int houlyrate){
        IdNumber=employNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.Sex = sex;
        this.BirthDate.set(Calendar.YEAR,Birthdate.get(Calendar.YEAR));
        this.BirthDate.set(Calendar.MONTH,Birthdate.get(Calendar.MONTH));
        this.BirthDate.set(Calendar.DATE,Birthdate.get(Calendar.DATE));
        this.hoursWorkedPerWeek = hours;
        super.HourlyRate = houlyrate;
    }

    public int monthlyEarning(){
        return hoursWorkedPerWeek * super.HourlyRate*4;
    }

    public String toString(){
        return
                "ID Employee number : "+this.IdNumber+
                        "\nEmployee name : "+this.firstName+this.lastName +
                        "\nBirth date : "+this.BirthDate.get(Calendar.MONTH)+"/"+this.BirthDate.get(Calendar.DATE)+"\nHours works per month : "+hoursWorkedPerWeek*4+"\nFull time Monthly Salary : "+monthlyEarning();
    }

    public void SetLastName(String lName){
        this.lastName = lName;
    }

    public void SetFirstName(String fName){
        this.firstName = fName;
    }

    public void SetBirthday(int year, int month,int day){
        this.BirthDate.set(Calendar.YEAR,year);
        this.BirthDate.set(Calendar.MONTH,month);
        this.BirthDate.set(Calendar.MONTH,day);
    }

    public void SetHourlyRate(int hourlyRate){
        this.HourlyRate = hourlyRate;
    }

    public String GetLastName(){
        return this.lastName;
    }

    public String GetFirstName(){
        return this.firstName;
    }

    public Calendar GetBirthday(){
        return this.BirthDate;
    }

    public int GetHourlyRate(){
        return this.HourlyRate;
    }
}


