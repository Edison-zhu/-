package www.membersheep.hk.web3j;

import com.alibaba.fastjson.JSON;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes3;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.utils.Bytes;

import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class TransctionContract {
    public static Web3j web3j = blockchain.getClient();

    /**
     * 部署合约
     */
    public  void deployment(){
        //部署合约的时候需要用到该账户的 gas，保证该账户的余额充足
        try{
            File file = new File("C:/Users/Edison/chain/data0/keystore/UTC--2018-05-21T01-41-38.065550500Z--6404c42a207dd5a58ed55a02bccdb5bec261ce7b");
            String passworld = "zyb955140";
            Credentials credentials = WalletUtils.loadCredentials(passworld,file);
            //部署合约
            C__Users_Edison_solidity_Transaction_sol_TransactionContract transactionContract = C__Users_Edison_solidity_Transaction_sol_TransactionContract.deploy(web3j, credentials, BigInteger.valueOf(200000), BigInteger.valueOf(20000000)).send();
            //打印合约地址
            System.out.println("合约地址:"+transactionContract.getContractAddress());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /**
     * 验证合约是否可用
     */
    public void verify(){
        File file = new File("C:/Users/Edison/chain/data0/keystore/UTC--2018-05-21T01-41-38.065550500Z--6404c42a207dd5a58ed55a02bccdb5bec261ce7b");
        String passworld = "zyb955140";
        Credentials credentials = null;
        try{
            credentials = WalletUtils.loadCredentials(passworld,file);
            //填入部署合约的地址
            String address = "0x82b537bb656afbbc701f2ad088d56e31b44f77ac";
            C__Users_Edison_solidity_Transaction_sol_TransactionContract transactionContract = C__Users_Edison_solidity_Transaction_sol_TransactionContract.load(
                    address,
                    web3j,
                    credentials,
                    BigInteger.valueOf(200000),
                    BigInteger.valueOf(20000000));
            String name = "朱燕冰";
            String identity = "410789199632521478";
            String hash = name;
            TransactionReceipt send = transactionContract.addTransaction(new Utf8String(name),new Bytes32(Arrays.copyOfRange(hash.getBytes(), 0, 32)), new Bytes32(Arrays.copyOfRange(hash.getBytes(),0,32))).send();


            System.out.println(send);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 将数据添加到智能合约中
     */
    public void addTransaction(){
        File file =new File ("C:/Users/Edison/chain/data0/keystore/UTC--2018-05-21T01-41-38.065550500Z--6404c42a207dd5a58ed55a02bccdb5bec261ce7b");
        String password = "zyb955140";
        Credentials credentials = null;
        try{
            credentials = WalletUtils.loadCredentials(password,file);
            //合约地址
            String address = "0x2fb7b0e1db4325cb6ddf192405dc80830406afd1";
            C__Users_Edison_solidity_Transaction_sol_TransactionContract transactionContract = C__Users_Edison_solidity_Transaction_sol_TransactionContract.load(
                    address,
                    web3j,
                    credentials,
                    BigInteger.valueOf(200000),
                    BigInteger.valueOf(20000000));
                    String name = "朱燕冰";
                    String identity = "199505140058";
                    String hash=name;
            TransactionReceipt send = transactionContract.addTransaction(new Utf8String(name),new Bytes32(Arrays.copyOfRange(hash.getBytes(), 0, 32)), new Bytes32(Arrays.copyOfRange(hash.getBytes(),0,32))).send();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 调用智能合约
     */
    public void getTransaction(){
        File file = new File("C:/Users/Edison/chain/data0/keystore/UTC--2018-05-21T01-41-38.065550500Z--6404c42a207dd5a58ed55a02bccdb5bec261ce7b");
        String passworld = "zyb955140";
        Credentials credentials = null;
        try{
            credentials = WalletUtils.loadCredentials(passworld,file);
            //填入部署合约的地址
            String address = "0x2fb7b0e1db4325cb6ddf192405dc80830406afd1";
            C__Users_Edison_solidity_Transaction_sol_TransactionContract transactionContract = C__Users_Edison_solidity_Transaction_sol_TransactionContract.load(
                    address,
                    web3j,
                    credentials,
                    BigInteger.valueOf(200000),
                    BigInteger.valueOf(20000000));
                //查询账户
            int count = transactionContract.getTransactionsLength().send().getValue().intValue();
            System.out.println("交易数量:"+count);
            for(int i=0;i<count;i++){
                Tuple4<Address, Utf8String,Bytes32,Bytes32> send = transactionContract.getTransaction(new Uint256(i)).send();
                System.out.println("第【"+i+"】条提交信息：姓名="+send.getValue2()+"\n编号="+getByteslong(send.getValue3())+"\nHASH值="+ JSON.toJSONString(send.getValue4())
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /**
     *
     */
    public static long getByteslong(Bytes32 data){
        byte[] bytes = Arrays.copyOfRange(data.getValue(),0,8);
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes,0,bytes.length);
        buffer.flip();
        long aLong = buffer.getLong();
        return aLong;
    }
}
