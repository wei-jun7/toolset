package weijunli.com.solcontract.weijunli.com.solcontract;

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

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

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
    public static final String BINARY = "6080604052348015600e575f80fd5b506104f28061001c5f395ff3fe608060405234801561000f575f80fd5b5060043610610055575f3560e01c80636acbdd53146100595780639df9e9ba14610077578063aa302f221461008a578063b2c8a31314610092578063d846feeb1461009a575b5f80fd5b6100616100af565b60405161006e9190610284565b60405180910390f35b6100616100853660046102cd565b61013e565b6100616101dd565b610061610268565b6100ad6100a83660046102cd565b610275565b005b60605f80546100bd90610378565b80601f01602080910402602001604051908101604052809291908181526020018280546100e990610378565b80156101345780601f1061010b57610100808354040283529160200191610134565b820191905f5260205f20905b81548152906001019060200180831161011757829003601f168201915b5050505050905090565b6060600161014c83826103fc565b506001805461015a90610378565b80601f016020809104026020016040519081016040528092919081815260200182805461018690610378565b80156101d15780601f106101a8576101008083540402835291602001916101d1565b820191905f5260205f20905b8154815290600101906020018083116101b457829003601f168201915b50505050509050919050565b5f80546101e990610378565b80601f016020809104026020016040519081016040528092919081815260200182805461021590610378565b80156102605780601f1061023757610100808354040283529160200191610260565b820191905f5260205f20905b81548152906001019060200180831161024357829003601f168201915b505050505081565b600180546101e990610378565b5f61028082826103fc565b5050565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b634e487b7160e01b5f52604160045260245ffd5b5f602082840312156102dd575f80fd5b813567ffffffffffffffff808211156102f4575f80fd5b818401915084601f830112610307575f80fd5b813581811115610319576103196102b9565b604051601f8201601f19908116603f01168101908382118183101715610341576103416102b9565b81604052828152876020848701011115610359575f80fd5b826020860160208301375f928101602001929092525095945050505050565b600181811c9082168061038c57607f821691505b6020821081036103aa57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156103f757805f5260205f20601f840160051c810160208510156103d55750805b601f840160051c820191505b818110156103f4575f81556001016103e1565b50505b505050565b815167ffffffffffffffff811115610416576104166102b9565b61042a816104248454610378565b846103b0565b602080601f83116001811461045d575f84156104465750858301515b5f19600386901b1c1916600185901b1785556104b4565b5f85815260208120601f198616915b8281101561048b5788860151825594840194600190910190840161046c565b50858210156104a857878501515f19600388901b60f8161c191681555b505060018460011b0185555b50505050505056fea26469706673582212201d6a56ad6854b2c8a90b1028d6ec95560b5e4776c0d0ef81586bca96e475508064736f6c63430008190033";

    public static final String FUNC_GETINPUTDATA = "getInputData";

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
