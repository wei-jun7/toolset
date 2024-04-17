package weijunli.com.solcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class SpamDectetor_sol_AIContract extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b5061092e8061001c5f395ff3fe608060405234801561000f575f80fd5b5060043610610060575f3560e01c80636acbdd53146100645780637a87b4bf146100825780639df9e9ba146100a0578063aa302f22146100d0578063b2c8a313146100ee578063d846feeb1461010c575b5f80fd5b61006c610128565b6040516100799190610482565b60405180910390f35b61008a6101b7565b6040516100979190610482565b60405180910390f35b6100ba60048036038101906100b591906105df565b610247565b6040516100c79190610482565b60405180910390f35b6100d86102e9565b6040516100e59190610482565b60405180910390f35b6100f6610374565b6040516101039190610482565b60405180910390f35b610126600480360381019061012191906105df565b610400565b005b60605f805461013690610653565b80601f016020809104026020016040519081016040528092919081815260200182805461016290610653565b80156101ad5780601f10610184576101008083540402835291602001916101ad565b820191905f5260205f20905b81548152906001019060200180831161019057829003601f168201915b5050505050905090565b6060600180546101c690610653565b80601f01602080910402602001604051908101604052809291908181526020018280546101f290610653565b801561023d5780601f106102145761010080835404028352916020019161023d565b820191905f5260205f20905b81548152906001019060200180831161022057829003601f168201915b5050505050905090565b606081600190816102589190610829565b506001805461026690610653565b80601f016020809104026020016040519081016040528092919081815260200182805461029290610653565b80156102dd5780601f106102b4576101008083540402835291602001916102dd565b820191905f5260205f20905b8154815290600101906020018083116102c057829003601f168201915b50505050509050919050565b5f80546102f590610653565b80601f016020809104026020016040519081016040528092919081815260200182805461032190610653565b801561036c5780601f106103435761010080835404028352916020019161036c565b820191905f5260205f20905b81548152906001019060200180831161034f57829003601f168201915b505050505081565b6001805461038190610653565b80601f01602080910402602001604051908101604052809291908181526020018280546103ad90610653565b80156103f85780601f106103cf576101008083540402835291602001916103f8565b820191905f5260205f20905b8154815290600101906020018083116103db57829003601f168201915b505050505081565b805f908161040e9190610829565b5050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f601f19601f8301169050919050565b5f61045482610412565b61045e818561041c565b935061046e81856020860161042c565b6104778161043a565b840191505092915050565b5f6020820190508181035f83015261049a818461044a565b905092915050565b5f604051905090565b5f80fd5b5f80fd5b5f80fd5b5f80fd5b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b6104f18261043a565b810181811067ffffffffffffffff821117156105105761050f6104bb565b5b80604052505050565b5f6105226104a2565b905061052e82826104e8565b919050565b5f67ffffffffffffffff82111561054d5761054c6104bb565b5b6105568261043a565b9050602081019050919050565b828183375f83830152505050565b5f61058361057e84610533565b610519565b90508281526020810184848401111561059f5761059e6104b7565b5b6105aa848285610563565b509392505050565b5f82601f8301126105c6576105c56104b3565b5b81356105d6848260208601610571565b91505092915050565b5f602082840312156105f4576105f36104ab565b5b5f82013567ffffffffffffffff811115610611576106106104af565b5b61061d848285016105b2565b91505092915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061066a57607f821691505b60208210810361067d5761067c610626565b5b50919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026106df7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826106a4565b6106e986836106a4565b95508019841693508086168417925050509392505050565b5f819050919050565b5f819050919050565b5f61072d61072861072384610701565b61070a565b610701565b9050919050565b5f819050919050565b61074683610713565b61075a61075282610734565b8484546106b0565b825550505050565b5f90565b61076e610762565b61077981848461073d565b505050565b5b8181101561079c576107915f82610766565b60018101905061077f565b5050565b601f8211156107e1576107b281610683565b6107bb84610695565b810160208510156107ca578190505b6107de6107d685610695565b83018261077e565b50505b505050565b5f82821c905092915050565b5f6108015f19846008026107e6565b1980831691505092915050565b5f61081983836107f2565b9150826002028217905092915050565b61083282610412565b67ffffffffffffffff81111561084b5761084a6104bb565b5b6108558254610653565b6108608282856107a0565b5f60209050601f831160018114610891575f841561087f578287015190505b610889858261080e565b8655506108f0565b601f19841661089f86610683565b5f5b828110156108c6578489015182556001820191506020850194506020810190506108a1565b868310156108e357848901516108df601f8916826107f2565b8355505b6001600288020188555050505b50505050505056fea2646970667358221220780cd3f86addb65ba26a561885a2765cbdb4d33fdb948711aeb85917482926dd64736f6c63430008190033";

    public static final String FUNC_GETINPUTDATA = "getInputData";

    public static final String FUNC_GETOUTPUTDATA = "getOutputData";

    public static final String FUNC_INPUTDATA = "inputData";

    public static final String FUNC_OUTPUTDATA = "outputData";

    public static final String FUNC_SETINPUTDATA = "setInputData";

    public static final String FUNC_SETOUTPUTDATA = "setOutputData";

    @Deprecated
    protected SpamDectetor_sol_AIContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SpamDectetor_sol_AIContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SpamDectetor_sol_AIContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SpamDectetor_sol_AIContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getInputData() {
        final Function function = new Function(FUNC_GETINPUTDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getOutputData() {
        final Function function = new Function(FUNC_GETOUTPUTDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> inputData() {
        final Function function = new Function(FUNC_INPUTDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> outputData() {
        final Function function = new Function(FUNC_OUTPUTDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setInputData(String _inputData) {
        final Function function = new Function(
                FUNC_SETINPUTDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_inputData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOutputData(String _outputData) {
        final Function function = new Function(
                FUNC_SETOUTPUTDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_outputData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SpamDectetor_sol_AIContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SpamDectetor_sol_AIContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SpamDectetor_sol_AIContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SpamDectetor_sol_AIContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SpamDectetor_sol_AIContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SpamDectetor_sol_AIContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SpamDectetor_sol_AIContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SpamDectetor_sol_AIContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SpamDectetor_sol_AIContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SpamDectetor_sol_AIContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SpamDectetor_sol_AIContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SpamDectetor_sol_AIContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SpamDectetor_sol_AIContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SpamDectetor_sol_AIContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SpamDectetor_sol_AIContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SpamDectetor_sol_AIContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
