pragma solidity ^0.4.21;

contract TransactionContract{

    //交易数组
    Transaction[] transactions;

    //交易信息
    struct Transaction{
        address sender; //信息提交者
        string customerName; //客户姓名
        bytes32 identity; //订单编号
        bytes32 identityHash; //hash唯一值
    }

    event AddTransaction(
        address indexed _sender,
        string _customerName,
        bytes32 _identity,
        bytes32 indexed _identityHash
    );

    function addTransaction(
        string _customerName,
        bytes32 _identity,
        bytes32 _identityHash
        ) public returns (uint) {
        Transaction memory transaction = Transaction({
            sender : msg.sender,
            customerName : _customerName,
            identity : _identity,
            identityHash : keccak256(_identityHash)
        });
        uint index = transactions.push(transaction) - 1;
        AddTransaction(
            transaction.sender,
            transaction.customerName,
            transaction.identity,
            transaction.identityHash
        );
        return index;
    }

    /// @dev 获取交易数组长度
    function getTransactionsLength() public view returns (uint) {
        return transactions.length;
    }

    function getTransaction(uint _index) public view returns(
        address sender,
        string customerName,
        bytes32 identity,
        bytes32 identityHash){
        Transaction storage transaction = transactions[_index];
        sender = transaction.sender;
        customerName = transaction.customerName;
        identity = transaction.identity;
        identityHash = transaction.identityHash;
    }



}
