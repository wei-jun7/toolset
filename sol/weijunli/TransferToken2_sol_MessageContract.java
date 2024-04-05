package weijunli;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.2.
 */
@SuppressWarnings("rawtypes")
public class TransferToken2_sol_MessageContract extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b50335f806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505f60035f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20819055506115ff806100bd5f395ff3fe608060405260043610610090575f3560e01c80638da5cb5b116100585780638da5cb5b14610186578063abcbb55f146101b0578063d0e30db0146101c6578063e8cc00ad146101d0578063eea758f1146101e657610090565b80631a90a2191461009457806323aa2a9d146100be57806327e235e3146100e6578063469c8110146101225780635fdd59f81461014a575b5f80fd5b34801561009f575f80fd5b506100a861020e565b6040516100b59190610b9a565b60405180910390f35b3480156100c9575f80fd5b506100e460048036038101906100df9190610be5565b610214565b005b3480156100f1575f80fd5b5061010c60048036038101906101079190610c6a565b6102e2565b6040516101199190610b9a565b60405180910390f35b34801561012d575f80fd5b5061014860048036038101906101439190610cf6565b6102f7565b005b348015610155575f80fd5b50610170600480360381019061016b9190610c6a565b6104cf565b60405161017d9190610db1565b60405180910390f35b348015610191575f80fd5b5061019a61056a565b6040516101a79190610de0565b60405180910390f35b3480156101bb575f80fd5b506101c461058d565b005b6101ce610699565b005b3480156101db575f80fd5b506101e4610769565b005b3480156101f1575f80fd5b5061020c60048036038101906102079190610e34565b610961565b005b60015481565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146102a1576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161029890610ee2565b60405180910390fd5b806001819055507fff2b76ea23158a77b4e6b7d2bbe0103263c46da136517a132f54c4241d25505d816040516102d79190610b9a565b60405180910390a150565b6003602052805f5260405f205f915090505481565b60015460035f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20541015610379576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161037090610f70565b60405180910390fd5b60015460035f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546103c79190610fbb565b9250508190555060015460035f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f82825461043c9190610fee565b92505081905550818160025f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20918261048f929190611252565b507f15340f1d3815fc99b59e3b9ed010321f64951d6e6a43c97a9e92713e7cd6ad173383836040516104c393929190611359565b60405180910390a15050565b6002602052805f5260405f205f9150905080546104eb90611085565b80601f016020809104026020016040519081016040528092919081815260200182805461051790611085565b80156105625780601f1061053957610100808354040283529160200191610562565b820191905f5260205f20905b81548152906001019060200180831161054557829003601f168201915b505050505081565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b5f60035f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205490505f8111610610576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610607906113d3565b60405180910390fd5b5f60035f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20819055503373ffffffffffffffffffffffffffffffffffffffff166108fc8290811502906040515f60405180830381858888f19350505050158015610695573d5f803e3d5ffd5b5050565b5f34116106db576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106d29061143b565b60405180910390fd5b3460035f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f8282546107279190610fee565b925050819055507f9936746a4565f9766fa768f88f56a7487c78780ac179562773d1c75c5269537e333460405161075f929190611459565b60405180910390a1565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146107f6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107ed90610ee2565b60405180910390fd5b5f60035f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205490505f8111610899576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610890906114ca565b60405180910390fd5b5f60035f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20819055505f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc8290811502906040515f60405180830381858888f1935050505015801561095d573d5f803e3d5ffd5b5050565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146109ee576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109e590610ee2565b60405180910390fd5b60035f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2054811115610a8e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a8590611532565b60405180910390fd5b8060035f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f828254610afa9190610fbb565b925050819055508173ffffffffffffffffffffffffffffffffffffffff166108fc8290811502906040515f60405180830381858888f19350505050158015610b44573d5f803e3d5ffd5b507fa171b6942063c6f2800ce40a780edce37baa2b618571b11eedd1e69e626e7d768282604051610b769291906115a2565b60405180910390a15050565b5f819050919050565b610b9481610b82565b82525050565b5f602082019050610bad5f830184610b8b565b92915050565b5f80fd5b5f80fd5b610bc481610b82565b8114610bce575f80fd5b50565b5f81359050610bdf81610bbb565b92915050565b5f60208284031215610bfa57610bf9610bb3565b5b5f610c0784828501610bd1565b91505092915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f610c3982610c10565b9050919050565b610c4981610c2f565b8114610c53575f80fd5b50565b5f81359050610c6481610c40565b92915050565b5f60208284031215610c7f57610c7e610bb3565b5b5f610c8c84828501610c56565b91505092915050565b5f80fd5b5f80fd5b5f80fd5b5f8083601f840112610cb657610cb5610c95565b5b8235905067ffffffffffffffff811115610cd357610cd2610c99565b5b602083019150836001820283011115610cef57610cee610c9d565b5b9250929050565b5f8060208385031215610d0c57610d0b610bb3565b5b5f83013567ffffffffffffffff811115610d2957610d28610bb7565b5b610d3585828601610ca1565b92509250509250929050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f601f19601f8301169050919050565b5f610d8382610d41565b610d8d8185610d4b565b9350610d9d818560208601610d5b565b610da681610d69565b840191505092915050565b5f6020820190508181035f830152610dc98184610d79565b905092915050565b610dda81610c2f565b82525050565b5f602082019050610df35f830184610dd1565b92915050565b5f610e0382610c10565b9050919050565b610e1381610df9565b8114610e1d575f80fd5b50565b5f81359050610e2e81610e0a565b92915050565b5f8060408385031215610e4a57610e49610bb3565b5b5f610e5785828601610e20565b9250506020610e6885828601610bd1565b9150509250929050565b7f4f6e6c7920746865206f776e65722063616e2063616c6c20746869732066756e5f8201527f6374696f6e2e0000000000000000000000000000000000000000000000000000602082015250565b5f610ecc602683610d4b565b9150610ed782610e72565b604082019050919050565b5f6020820190508181035f830152610ef981610ec0565b9050919050565b7f496e73756666696369656e742062616c616e636520746f2073656e64206d65735f8201527f736167652e000000000000000000000000000000000000000000000000000000602082015250565b5f610f5a602583610d4b565b9150610f6582610f00565b604082019050919050565b5f6020820190508181035f830152610f8781610f4e565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f610fc582610b82565b9150610fd083610b82565b9250828203905081811115610fe857610fe7610f8e565b5b92915050565b5f610ff882610b82565b915061100383610b82565b925082820190508082111561101b5761101a610f8e565b5b92915050565b5f82905092915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061109c57607f821691505b6020821081036110af576110ae611058565b5b50919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026111117fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826110d6565b61111b86836110d6565b95508019841693508086168417925050509392505050565b5f819050919050565b5f61115661115161114c84610b82565b611133565b610b82565b9050919050565b5f819050919050565b61116f8361113c565b61118361117b8261115d565b8484546110e2565b825550505050565b5f90565b61119761118b565b6111a2818484611166565b505050565b5b818110156111c5576111ba5f8261118f565b6001810190506111a8565b5050565b601f82111561120a576111db816110b5565b6111e4846110c7565b810160208510156111f3578190505b6112076111ff856110c7565b8301826111a7565b50505b505050565b5f82821c905092915050565b5f61122a5f198460080261120f565b1980831691505092915050565b5f611242838361121b565b9150826002028217905092915050565b61125c8383611021565b67ffffffffffffffff8111156112755761127461102b565b5b61127f8254611085565b61128a8282856111c9565b5f601f8311600181146112b7575f84156112a5578287013590505b6112af8582611237565b865550611316565b601f1984166112c5866110b5565b5f5b828110156112ec578489013582556001820191506020850194506020810190506112c7565b868310156113095784890135611305601f89168261121b565b8355505b6001600288020188555050505b50505050505050565b828183375f83830152505050565b5f6113388385610d4b565b935061134583858461131f565b61134e83610d69565b840190509392505050565b5f60408201905061136c5f830186610dd1565b818103602083015261137f81848661132d565b9050949350505050565b7f4e6f2062616c616e636520746f2077697468647261772e0000000000000000005f82015250565b5f6113bd601783610d4b565b91506113c882611389565b602082019050919050565b5f6020820190508181035f8301526113ea816113b1565b9050919050565b7f596f75206d7573742073656e6420736f6d652045746865722e000000000000005f82015250565b5f611425601983610d4b565b9150611430826113f1565b602082019050919050565b5f6020820190508181035f83015261145281611419565b9050919050565b5f60408201905061146c5f830185610dd1565b6114796020830184610b8b565b9392505050565b7f4e6f206368617267657320746f2077697468647261772e0000000000000000005f82015250565b5f6114b4601783610d4b565b91506114bf82611480565b602082019050919050565b5f6020820190508181035f8301526114e1816114a8565b9050919050565b7f496e73756666696369656e742062616c616e636520666f7220726566756e642e5f82015250565b5f61151c602083610d4b565b9150611527826114e8565b602082019050919050565b5f6020820190508181035f83015261154981611510565b9050919050565b5f61156a61156561156084610c10565b611133565b610c10565b9050919050565b5f61157b82611550565b9050919050565b5f61158c82611571565b9050919050565b61159c81611582565b82525050565b5f6040820190506115b55f830185611593565b6115c26020830184610b8b565b939250505056fea2646970667358221220e242cc9c31f0a24c666b5720656ddce040eeb0f39d68293818b8d11db3aab06a64736f6c63430008190033";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_MESSAGEFEE = "messageFee";

    public static final String FUNC_MESSAGES = "messages";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_REFUNDUSER = "refundUser";

    public static final String FUNC_SENDMESSAGE = "sendMessage";

    public static final String FUNC_SETMESSAGEFEE = "setMessageFee";

    public static final String FUNC_WITHDRAWOWNER = "withdrawOwner";

    public static final String FUNC_WITHDRAWUSER = "withdrawUser";

    public static final Event DEPOSITRECEIVED_EVENT = new Event("DepositReceived", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event MESSAGEFEEUPDATED_EVENT = new Event("MessageFeeUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MESSAGERECEIVED_EVENT = new Event("MessageReceived", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event REFUNDISSUED_EVENT = new Event("RefundIssued", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected TransferToken2_sol_MessageContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferToken2_sol_MessageContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TransferToken2_sol_MessageContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TransferToken2_sol_MessageContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<DepositReceivedEventResponse> getDepositReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DEPOSITRECEIVED_EVENT, transactionReceipt);
        ArrayList<DepositReceivedEventResponse> responses = new ArrayList<DepositReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositReceivedEventResponse typedResponse = new DepositReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static DepositReceivedEventResponse getDepositReceivedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(DEPOSITRECEIVED_EVENT, log);
        DepositReceivedEventResponse typedResponse = new DepositReceivedEventResponse();
        typedResponse.log = log;
        typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<DepositReceivedEventResponse> depositReceivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getDepositReceivedEventFromLog(log));
    }

    public Flowable<DepositReceivedEventResponse> depositReceivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSITRECEIVED_EVENT));
        return depositReceivedEventFlowable(filter);
    }

    public static List<MessageFeeUpdatedEventResponse> getMessageFeeUpdatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MESSAGEFEEUPDATED_EVENT, transactionReceipt);
        ArrayList<MessageFeeUpdatedEventResponse> responses = new ArrayList<MessageFeeUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MessageFeeUpdatedEventResponse typedResponse = new MessageFeeUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newCharge = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static MessageFeeUpdatedEventResponse getMessageFeeUpdatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(MESSAGEFEEUPDATED_EVENT, log);
        MessageFeeUpdatedEventResponse typedResponse = new MessageFeeUpdatedEventResponse();
        typedResponse.log = log;
        typedResponse.newCharge = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<MessageFeeUpdatedEventResponse> messageFeeUpdatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMessageFeeUpdatedEventFromLog(log));
    }

    public Flowable<MessageFeeUpdatedEventResponse> messageFeeUpdatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MESSAGEFEEUPDATED_EVENT));
        return messageFeeUpdatedEventFlowable(filter);
    }

    public static List<MessageReceivedEventResponse> getMessageReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MESSAGERECEIVED_EVENT, transactionReceipt);
        ArrayList<MessageReceivedEventResponse> responses = new ArrayList<MessageReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MessageReceivedEventResponse typedResponse = new MessageReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static MessageReceivedEventResponse getMessageReceivedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(MESSAGERECEIVED_EVENT, log);
        MessageReceivedEventResponse typedResponse = new MessageReceivedEventResponse();
        typedResponse.log = log;
        typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<MessageReceivedEventResponse> messageReceivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMessageReceivedEventFromLog(log));
    }

    public Flowable<MessageReceivedEventResponse> messageReceivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MESSAGERECEIVED_EVENT));
        return messageReceivedEventFlowable(filter);
    }

    public static List<RefundIssuedEventResponse> getRefundIssuedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REFUNDISSUED_EVENT, transactionReceipt);
        ArrayList<RefundIssuedEventResponse> responses = new ArrayList<RefundIssuedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RefundIssuedEventResponse typedResponse = new RefundIssuedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RefundIssuedEventResponse getRefundIssuedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(REFUNDISSUED_EVENT, log);
        RefundIssuedEventResponse typedResponse = new RefundIssuedEventResponse();
        typedResponse.log = log;
        typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<RefundIssuedEventResponse> refundIssuedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRefundIssuedEventFromLog(log));
    }

    public Flowable<RefundIssuedEventResponse> refundIssuedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REFUNDISSUED_EVENT));
        return refundIssuedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> messageFee() {
        final Function function = new Function(FUNC_MESSAGEFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> messages(String param0) {
        final Function function = new Function(FUNC_MESSAGES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> refundUser(String recipient, BigInteger amount) {
        final Function function = new Function(
                FUNC_REFUNDUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendMessage(String message) {
        final Function function = new Function(
                FUNC_SENDMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(message)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setMessageFee(BigInteger _fee) {
        final Function function = new Function(
                FUNC_SETMESSAGEFEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_fee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawOwner() {
        final Function function = new Function(
                FUNC_WITHDRAWOWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawUser() {
        final Function function = new Function(
                FUNC_WITHDRAWUSER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TransferToken2_sol_MessageContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferToken2_sol_MessageContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TransferToken2_sol_MessageContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferToken2_sol_MessageContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TransferToken2_sol_MessageContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TransferToken2_sol_MessageContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TransferToken2_sol_MessageContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TransferToken2_sol_MessageContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TransferToken2_sol_MessageContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TransferToken2_sol_MessageContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TransferToken2_sol_MessageContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TransferToken2_sol_MessageContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TransferToken2_sol_MessageContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferToken2_sol_MessageContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TransferToken2_sol_MessageContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferToken2_sol_MessageContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class DepositReceivedEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class MessageFeeUpdatedEventResponse extends BaseEventResponse {
        public BigInteger newCharge;
    }

    public static class MessageReceivedEventResponse extends BaseEventResponse {
        public String sender;

        public String message;
    }

    public static class RefundIssuedEventResponse extends BaseEventResponse {
        public String recipient;

        public BigInteger amount;
    }
}
