package callBack;
public class Seller
{
    private String name = null;

    public Seller(String name)
    {        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public void setName(String name)
    {        this.name = name;
    }

    public class doHomeWork implements doJob
    {

        @Override
        public void fillBlank(int a, int b, int result)
        {            // TODO Auto-generated method stub
            System.out.println(name + "«Û÷˙–°∫ÏÀ„’À:" + a + " + " + b + " = " + result + "‘™");
        }

    }

    public void callHelp (int a, int b)
    {        new SuperCalculator().add(a, b, new doHomeWork());
    }
}