package www.membersheep.hk.web3j;

import org.apache.ibatis.transaction.TransactionException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class Accounts {
    public static Web3j web3j = blockchain.getClient();


    /**
     * 获得账号列表
     * @return
     */
    public List<String> getAccountslist(){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取账号信息
     * @param index
     * @return
     */
    public String getAccounts(int index){
        String account = null;
        try {
            account = web3j.ethAccounts().send().getAccounts().get(index);
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }
    /**
     * 获取账号余额
     */
    public BigInteger getBalance(String account) throws IOException {

        EthGetBalance ethGetBalance = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).send();
        BigInteger  balance = ethGetBalance.getBalance();
        return balance;

    }
    public void transfer(String account, float coin)
            throws InterruptedException, IOException, TransactionException, Exception {
        String password = "";
        String walletfile = "/Users/neo/netkiller/UTC--2018-01-20T04-04-06.786586541Z--83fda0ba7e6cfa8d7319d78fa0e6b753a2bcb5a6";
        Credentials credentials = WalletUtils.loadCredentials(password, walletfile);
        TransactionReceipt transactionReceipt = Transfer
                .sendFunds(web3j, credentials, account, BigDecimal.valueOf(coin), Convert.Unit.ETHER).send();
        System.out.println(transactionReceipt.getStatus());
    }
}
