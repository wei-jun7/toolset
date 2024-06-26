package weijunli.com.ui.slideshow;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class Test_sol_Messenger extends Contract {
    public static final String BINARY = "608060405234801561000f575f80fd5b505f808055604080516020810190915290815260019061002f90826100df565b50600280546001600160a01b0319163317905561019e565b634e487b7160e01b5f52604160045260245ffd5b600181811c9082168061006f57607f821691505b60208210810361008d57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156100da57805f5260205f20601f840160051c810160208510156100b85750805b601f840160051c820191505b818110156100d7575f81556001016100c4565b50505b505050565b81516001600160401b038111156100f8576100f8610047565b61010c81610106845461005b565b84610093565b602080601f83116001811461013f575f84156101285750858301515b5f19600386901b1c1916600185901b178555610196565b5f85815260208120601f198616915b8281101561016d5788860151825594840194600190910190840161014e565b508582101561018a57878501515f19600388901b60f8161c191681555b505060018460011b0185555b505050505050565b61042c806101ab5f395ff3fe608060405234801561000f575f80fd5b5060043610610055575f3560e01c80631923be24146100595780638da5cb5b1461006e578063a4e406f21461009e578063aaf4389a146100af578063e21f37ce146100b7575b5f80fd5b61006c6100673660046101de565b6100cc565b005b600254610081906001600160a01b031681565b6040516001600160a01b0390911681526020015b60405180910390f35b5f545b604051908152602001610095565b6100a15f5481565b6100bf610152565b604051610095919061024a565b6002546001600160a01b0316331461012a5760405162461bcd60e51b815260206004820152601960248201527f6f6e6c7920746865206f776e65722063616e2075706461746500000000000000604482015260640160405180910390fd5b6001610137828483610317565b5060015f8082825461014991906103d1565b90915550505050565b6001805461015f90610293565b80601f016020809104026020016040519081016040528092919081815260200182805461018b90610293565b80156101d65780601f106101ad576101008083540402835291602001916101d6565b820191905f5260205f20905b8154815290600101906020018083116101b957829003601f168201915b505050505081565b5f80602083850312156101ef575f80fd5b823567ffffffffffffffff80821115610206575f80fd5b818501915085601f830112610219575f80fd5b813581811115610227575f80fd5b866020828501011115610238575f80fd5b60209290920196919550909350505050565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b634e487b7160e01b5f52604160045260245ffd5b600181811c908216806102a757607f821691505b6020821081036102c557634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561031257805f5260205f20601f840160051c810160208510156102f05750805b601f840160051c820191505b8181101561030f575f81556001016102fc565b50505b505050565b67ffffffffffffffff83111561032f5761032f61027f565b6103438361033d8354610293565b836102cb565b5f601f841160018114610374575f851561035d5750838201355b5f19600387901b1c1916600186901b17835561030f565b5f83815260208120601f198716915b828110156103a35786850135825560209485019460019092019101610383565b50868210156103bf575f1960f88860031b161c19848701351681555b505060018560011b0183555050505050565b808201808211156103f057634e487b7160e01b5f52601160045260245ffd5b9291505056fea26469706673582212209c603551b924c0bad738ce28d401cf311c33b61a829b19f7331daee7213f407164736f6c63430008190033";

    public static final String FUNC_CHANGECOUNTER = "changeCounter";

    public static final String FUNC_GETCHANGECOUNTER = "getChangeCounter";

    public static final String FUNC_MESSAGE = "message";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_UPDATEMESSAGE = "updateMessage";

    @Deprecated
    protected Test_sol_Messenger(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Test_sol_Messenger(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Test_sol_Messenger(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Test_sol_Messenger(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> changeCounter() {
        final Function function = new Function(FUNC_CHANGECOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getChangeCounter() {
        final Function function = new Function(FUNC_GETCHANGECOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> message() {
        final Function function = new Function(FUNC_MESSAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateMessage(String newMessage) {
        final Function function = new Function(
                FUNC_UPDATEMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(newMessage)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Test_sol_Messenger load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test_sol_Messenger(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Test_sol_Messenger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test_sol_Messenger(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Test_sol_Messenger load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Test_sol_Messenger(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Test_sol_Messenger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Test_sol_Messenger(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Test_sol_Messenger> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test_sol_Messenger.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Test_sol_Messenger> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test_sol_Messenger.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test_sol_Messenger> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test_sol_Messenger.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test_sol_Messenger> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test_sol_Messenger.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
