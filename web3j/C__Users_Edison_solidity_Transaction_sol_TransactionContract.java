package www.membersheep.hk.web3j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class C__Users_Edison_solidity_Transaction_sol_TransactionContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610561806100206000396000f3006080604052600436106100565763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166333ea3dc8811461005b578063e3f941b614610116578063f21936271461018a575b600080fd5b34801561006757600080fd5b5061007360043561019f565b6040805173ffffffffffffffffffffffffffffffffffffffff861681529081018390526060810182905260806020808301828152865192840192909252855160a084019187019080838360005b838110156100d85781810151838201526020016100c0565b50505050905090810190601f1680156101055780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561012257600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261017894369492936024939284019190819084018382808284375094975050843595505050602090920135915061028b9050565b60408051918252519081900360200190f35b34801561019657600080fd5b5061017861046e565b60006060600080600080868154811015156101b657fe5b600091825260209182902060049091020180546001808301805460408051601f600260001996851615610100029690960190931694909404918201879004870284018701905280835273ffffffffffffffffffffffffffffffffffffffff90931699509294509283018282801561026e5780601f106102435761010080835404028352916020019161026e565b820191906000526020600020905b81548152906001019060200180831161025157829003601f168201915b505050505093508060020154925080600301549150509193509193565b6000610295610475565b5060408051608081018252338152602080820187815282840187905283518681529351938490038201909320606083015260008054600180820180845583805285517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5636004909402938401805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff90921691909117815596518051969794969295919488949093610379937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564909201929091019061049d565b5060408281015160028301556060928301516003909201919091558582015186516020808901518985015185518084018290528681528251968101969096528151989097039850929673ffffffffffffffffffffffffffffffffffffffff909216957f15b60bdf3aa1ab75fb53c4ad65b4e9e688620ac2ccca14727b7ec62ee5daeeb19593949093909283929183019186019080838360005b8381101561042a578181015183820152602001610412565b50505050905090810190601f1680156104575780820380516001836020036101000a031916815260200191505b50935050505060405180910390a395945050505050565b6000545b90565b6040805160808101825260008082526060602083018190529282018190529181019190915290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106104de57805160ff191683800117855561050b565b8280016001018555821561050b579182015b8281111561050b5782518255916020019190600101906104f0565b5061051792915061051b565b5090565b61047291905b8082111561051757600081556001016105215600a165627a7a72305820e73a06d0166eeb001fd27cb9b7bddb720b4affeeb9356ad9f04d809524191fa70029";

    public static final String FUNC_GETTRANSACTION = "getTransaction";

    public static final String FUNC_ADDTRANSACTION = "addTransaction";

    public static final String FUNC_GETTRANSACTIONSLENGTH = "getTransactionsLength";

    public static final Event ADDTRANSACTION_EVENT = new Event("AddTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
    ;

    protected C__Users_Edison_solidity_Transaction_sol_TransactionContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected C__Users_Edison_solidity_Transaction_sol_TransactionContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple4<Address, Utf8String, Bytes32, Bytes32>> getTransaction(Uint256 _index) {
        final Function function = new Function(FUNC_GETTRANSACTION, 
                Arrays.<Type>asList(_index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteCall<Tuple4<Address, Utf8String, Bytes32, Bytes32>>(
                new Callable<Tuple4<Address, Utf8String, Bytes32, Bytes32>>() {
                    @Override
                    public Tuple4<Address, Utf8String, Bytes32, Bytes32> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<Address, Utf8String, Bytes32, Bytes32>(
                                (Address) results.get(0), 
                                (Utf8String) results.get(1), 
                                (Bytes32) results.get(2), 
                                (Bytes32) results.get(3));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addTransaction(Utf8String _customerName, Bytes32 _identity, Bytes32 _identityHash) {
        final Function function = new Function(
                FUNC_ADDTRANSACTION, 
                Arrays.<Type>asList(_customerName, _identity, _identityHash), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> getTransactionsLength() {
        final Function function = new Function(FUNC_GETTRANSACTIONSLENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public List<AddTransactionEventResponse> getAddTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDTRANSACTION_EVENT, transactionReceipt);
        ArrayList<AddTransactionEventResponse> responses = new ArrayList<AddTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddTransactionEventResponse typedResponse = new AddTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._sender = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._identityHash = (Bytes32) eventValues.getIndexedValues().get(1);
            typedResponse._customerName = (Utf8String) eventValues.getNonIndexedValues().get(0);
            typedResponse._identity = (Bytes32) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddTransactionEventResponse> addTransactionEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddTransactionEventResponse>() {
            @Override
            public AddTransactionEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDTRANSACTION_EVENT, log);
                AddTransactionEventResponse typedResponse = new AddTransactionEventResponse();
                typedResponse.log = log;
                typedResponse._sender = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._identityHash = (Bytes32) eventValues.getIndexedValues().get(1);
                typedResponse._customerName = (Utf8String) eventValues.getNonIndexedValues().get(0);
                typedResponse._identity = (Bytes32) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Observable<AddTransactionEventResponse> addTransactionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDTRANSACTION_EVENT));
        return addTransactionEventObservable(filter);
    }

    public static RemoteCall<C__Users_Edison_solidity_Transaction_sol_TransactionContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(C__Users_Edison_solidity_Transaction_sol_TransactionContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<C__Users_Edison_solidity_Transaction_sol_TransactionContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(C__Users_Edison_solidity_Transaction_sol_TransactionContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static C__Users_Edison_solidity_Transaction_sol_TransactionContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new C__Users_Edison_solidity_Transaction_sol_TransactionContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static C__Users_Edison_solidity_Transaction_sol_TransactionContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new C__Users_Edison_solidity_Transaction_sol_TransactionContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class AddTransactionEventResponse {
        public Log log;

        public Address _sender;

        public Bytes32 _identityHash;

        public Utf8String _customerName;

        public Bytes32 _identity;
    }
}
