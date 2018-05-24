package www.membersheep.hk.web3j;


import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * web3j连接私有链
 */
public class blockchain {
    private  static  String ip = "http://localhost:8545/";
    private blockchain(){}
    private volatile  static Web3j web3j;


    public static Web3j getClient(){
         if(web3j==null){
             synchronized (blockchain.class){
                 if(web3j==null){
                     web3j = Web3j.build(new HttpService(ip));
                 }
             }
         }
         return web3j;
    }
}
