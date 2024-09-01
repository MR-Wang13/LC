
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
class Account{
    private String accountId;
    private int timestamp;
    private int balance;
    private int transVal;

    public int getTransVal(){
        return this.transVal;
    }
    public String getAccountId(){
        return this.accountId;
    }
    public int getBalance(){
        return this.balance;
    }
    public Account(String accountId,int timestamp,int balance,int transVal){
        this.accountId = accountId;
        this.timestamp = timestamp;
        this.balance = balance;
        this.transVal = transVal;
    }

    public int deposit(int amount){
        this.transVal+=amount;
        return this.balance+=amount;
    }

    public int pay(int amount){
        this.transVal+=amount;
        return this.balance-=amount;
    }

}
public class BankingSystemImpl {
    HashMap<String,Account> accMap;

    ArrayList<Account> allAcc;
    Comparator<Account> acComparator ;
    public BankingSystemImpl() {
        // TODO: implement
        accMap = new HashMap<>();
        acComparator = (a,b) ->{
            return b.getBalance() - a.getBalance();
        };
        allAcc = new ArrayList<>();
    }

    // TODO: implement interface methods here

    public boolean createAccount(int timestamp, String accountId){
        if(accMap.containsKey(accountId)){
            return false;
        }
        Account acc  = new Account(accountId, timestamp, 0,0);
        allAcc.add(acc);
        accMap.put(accountId, acc);
        return true;
    }

    public Optional<Integer> deposit(int timestamp, String accountId, int     amount){
        if(!accMap.containsKey(accountId)){
            return Optional.empty();
        }
        Account acc  = accMap.get(accountId);
        return Optional.of(acc.deposit(amount));
    }

    public Optional<Integer> pay(int timestamp, String accountId, int amount){
        Account acc  = accMap.get(accountId);
        if(acc==null || acc.getBalance()<amount){
            return Optional.empty();
        }
        return Optional.of(acc.pay(amount));
    }

    public List<String> topActivity(int timestamp, int n){
        ArrayList<String> topList = new ArrayList<>();
        Collections.sort(allAcc,acComparator);
        for(int i = 0 ; i<n ;i++){
            Account acc = allAcc.get(i);
            String activityStr = acc.getAccountId() + "("+acc.getTransVal()+")";
            topList.add(activityStr);
        }
        return topList;
    }

    public static void main(String[] args) {

        BankingSystemImpl im = new BankingSystemImpl();

        im.createAccount(1,"a1");
        im.createAccount(2,"a2");
        im.createAccount(2,"a3");
        im.deposit(1,"a1",500);
        im.pay(1,"a1",100);
        im.deposit(1,"a2",100);
        im.pay(1,"a2",300);
        System.out.println(im.topActivity(1,3));

    }

}
