package dp;

class CombinationLock
{
    private int [] combination;
    public String status;
    public int digitsEntered = 0 ,count;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        status = "LOCKED";
    }

    public void enterDigit(int digit)
    {
        if(status == "LOCKED") {
            status = "";
        }
        status += digit;

        if (combination[digitsEntered] == digit) {
            count++;
        }
        digitsEntered++;
        if(digitsEntered == combination.length)
            status = count==combination.length ? "OPEN" : "ERROR";
    }
}
