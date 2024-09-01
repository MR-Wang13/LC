package ng.ramp;

import java.util.*;

class Account{
    private String accountId;
    private Integer amount;

    private Integer activeNum;

    public String getAccountId() {
        return accountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getActiveNum() {
        return activeNum;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    private String timeStamp;

    public Account(String accountId, Integer amount, Integer activeNum, String timeStamp) {
        this.accountId = accountId;
        this.amount = amount;
        this.activeNum = activeNum;
        this.timeStamp = timeStamp;
    }

    int pay (int amount){
        activeAmount(amount);
        return this.amount-=amount;
    }

    void activeAmount(int amount){
        activeNum+=amount;
    }

    int deposit(int amount){
        activeAmount(amount);
        return this.amount+=amount;
    }
}
class Transfer{

    public String transferId;
    public String sourceId;
    public String targetId;
    public Integer amount;

    public String timeStamp;

    public Transfer(String transferId, String sourceId, String targetId, Integer amount, String timeStamp) {
        this.transferId = transferId;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }


    public void accpect(Account sourceAcc, Account targetAcc) {
        sourceAcc.pay(amount);
        targetAcc.deposit(amount);
    }

    public boolean isExpired(String time) {
        return Long.valueOf(time)>Long.valueOf(timeStamp);
    }
}
public class BankOOP {
    HashMap<String,Account> accountMap;

    HashMap<String,Transfer> transferMap;

    ArrayList<Account> allAcc;
    Comparator<Account> accountComparator;

    Integer transFerSerialNumber ;
    public BankOOP(){
        accountMap = new HashMap<>();
        transferMap = new HashMap<>();
        allAcc = new ArrayList<>();
        accountComparator = (a,b)-> b.getActiveNum()-a.getActiveNum();

        transFerSerialNumber= 1;

    }



    public boolean createAcc(String accountId){
        if (accountMap.containsKey(accountId)){
            return false;
        }
        Account acc = new Account(accountId,0,0,"0");
        allAcc.add(acc);
        accountMap.put(accountId,acc);
        return true;
    }

    public int deposit(String accountId,int amount){
        Account acc = accountMap.get(accountId);
        if (acc==null){
            return -1;
        }
       return acc.deposit(amount);
    }

    public int pay(String accountId,int amount){
        Account acc = accountMap.get(accountId);
        if (acc==null){
            return -1;
        }

        return acc.pay(amount);
    }

    public void topActivity(int top){

        Collections.sort(allAcc,accountComparator);

        for (int i= 0; i<top; i++){
            System.out.println(allAcc.get(i));
        }
    }

    public String transfer(String time,String source,String target,int amount){

        Account sourceAcc= accountMap.get(source);
        Account targetAcc= accountMap.get(target);
        if (source.equals(targetAcc)||sourceAcc==null||targetAcc==null){
            return "";
        }
        String transferId = String.valueOf(transFerSerialNumber);
        transFerSerialNumber++;
        Transfer transfer = new Transfer(transferId,source,target,amount,time);
        transferMap.put(transferId,transfer);
        return transferId;

    }

    public boolean acceptTransfer(String time,String accId,String transId){
        Transfer transfer = transferMap.get(transId);
        Account targetAcc = accountMap.get(accId);
        if (transfer == null ||transfer.isExpired(time)|| !targetAcc.getAccountId().equals(transfer.targetId)){
            return false;
        }
        Account sourceAcc = accountMap.get(transfer.sourceId);

        transfer.accpect(sourceAcc,targetAcc);
        return true;
    }

    public static void main(String[] args) {
       Account acc1 = new Account("a1",0,200,"0");
        Account acc2 = new Account("a2",0,100,"0");
        ArrayList<Account> list= new ArrayList<>();
        Comparator<Account>  accountComparator = (a,b)-> b.getActiveNum()-a.getActiveNum();
        list.add(acc1);
        list.add(acc2);
        Collections.sort(list,accountComparator);
        System.out.println("a2".compareTo("a1"));
    }

}
