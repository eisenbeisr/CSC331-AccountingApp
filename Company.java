public class Company {
    public double total_funds;
    public double it_funds_percentage;
    public double Marketing_funds_percentage;
    public double Sales_funds_percentage;
    public double Production_funds_percentage;
    public double HR_funds_percentage;
    public double it_funds;
    public double Marketing_funds;
    public double Sales_funds;
    public double Production_funds;
    public double HR_funds;
    public double Dept_percentage;
    public Department[] array = new Department[5];

    public Company(float total_funds, double Dept_percentage) {
        this.total_funds = total_funds;
        this.Dept_percentage = Dept_percentage;
        this.Marketing_funds_percentage = Dept_percentage;
        this.Sales_funds_percentage = Dept_percentage;
        this.Production_funds_percentage = Dept_percentage;
        this.HR_funds_percentage = Dept_percentage;
        this.it_funds_percentage = Dept_percentage;
        this.Marketing_funds = this.Marketing_funds_percentage * total_funds;
        this.Sales_funds = this.Sales_funds_percentage * total_funds;
        this.Production_funds = this.Production_funds_percentage * total_funds;
        this.HR_funds = this.HR_funds_percentage * total_funds;
        this.it_funds = this.it_funds_percentage * total_funds;
        this.array[0] = new Department("Marketing", Marketing_funds);
        this.array[1] = new Department("Sales", Sales_funds);
        this.array[2] = new Department("Production", Production_funds);
        this.array[3] = new Department("HR", HR_funds);
        this.array[4] = new Department("IT", it_funds);
    }


    public void reset_Dep_funds() {
        this.Marketing_funds_percentage = 20;
        this.Sales_funds_percentage = 20;
        this.Production_funds_percentage = 20;
        this.HR_funds_percentage = 20;
        this.it_funds_percentage = 20;
        this.HR_funds = (this.HR_funds_percentage/100) * this.total_funds;
        this.Marketing_funds = (this.Marketing_funds_percentage/100) * this.total_funds;
        this.Sales_funds = (this.Sales_funds_percentage/100) * this.total_funds;
        this.Production_funds = (this.Production_funds_percentage/100) * total_funds;
        this.it_funds = (this.it_funds_percentage/100) * total_funds;
        array[0].Dept_funds = this.Marketing_funds;
        array[1].Dept_funds = this.Sales_funds;
        array[2].Dept_funds = this.Production_funds;
        array[3].Dept_funds = this.HR_funds;
        array[4].Dept_funds = this.it_funds;
    }

    public double deposit(String name, double amount) {
        int x = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].dept_name == name) {
                this.array[i].Dept_funds = this.array[i].Dept_funds + amount;
                x = i;
            }
        }
        return this.array[x].Dept_funds;
    }

    public double withdraw(String name, double amount) {
        int x = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].dept_name == name) {
                x = i;
                this.array[i].Dept_funds = this.array[i].Dept_funds - amount;
            }
        }
        return this.array[x].Dept_funds;
    }
    public void adjustPieChart(){
        this.Marketing_funds_percentage = 100/(total_funds/this.Marketing_funds);
        this.Sales_funds_percentage = 100/(total_funds/this.Sales_funds);
        this.Production_funds_percentage = 100/(total_funds/this.Production_funds);
        this.HR_funds_percentage = 100/(total_funds/this.HR_funds);
        this.it_funds_percentage = 100/(total_funds/this.it_funds);
    }
    public void adjustTotal(){
        this.total_funds=(0.0);
        for (int i = 0; i < 5; i++){
            this.total_funds = this.array[i].Dept_funds + this.total_funds;
        }
    }
}