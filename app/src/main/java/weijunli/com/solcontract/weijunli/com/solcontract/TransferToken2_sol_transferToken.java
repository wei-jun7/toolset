package weijunli.com.solcontract.weijunli.com.solcontract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class TransferToken2_sol_transferToken extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b50335f806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506109f68061005b5f395ff3fe60806040526004361061003e575f3560e01c8063469c8110146100425780638da5cb5b1461005e57806395f7c02614610088578063d9e95a98146100b0575b5f80fd5b61005c600480360381019061005791906105fa565b6100d8565b005b348015610069575f80fd5b5061007261016f565b60405161007f9190610680565b60405180910390f35b348015610093575f80fd5b506100ae60048036038101906100a991906105fa565b610192565b005b3480156100bb575f80fd5b506100d660048036038101906100d191906106c3565b610368565b005b5f341161011a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161011190610777565b60405180910390fd5b5f8160405160200161012c91906107e7565b6040516020818303038152906040528051906020012090503460015f8381526020019081526020015f205f8282546101649190610833565b925050819055505050565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b5f816040516020016101a491906107e7565b6040516020818303038152906040528051906020012090505f60025f8381526020019081526020015f2080548060200260200160405190810160405280929190818152602001828054801561024b57602002820191905f5260205f20905b815f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610202575b505050505090505f815190505f8111610299576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610290906108b0565b60405180910390fd5b5f8160015f8681526020019081526020015f20546102b791906108fb565b90505f5b8281101561032e578381815181106102d6576102d561092b565b5b602002602001015173ffffffffffffffffffffffffffffffffffffffff166108fc8390811502906040515f60405180830381858888f19350505050158015610320573d5f803e3d5ffd5b5080806001019150506102bb565b505f60015f8681526020019081526020015f208190555060025f8581526020019081526020015f205f6103619190610474565b5050505050565b5f73ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16036103d6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103cd906109a2565b60405180910390fd5b5f816040516020016103e891906107e7565b60405160208183030381529060405280519060200120905060025f8281526020019081526020015f2083908060018154018082558091505060019003905f5260205f20015f9091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b5080545f8255905f5260205f209081019061048f9190610492565b50565b5b808211156104a9575f815f905550600101610493565b5090565b5f604051905090565b5f80fd5b5f80fd5b5f80fd5b5f80fd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b61050c826104c6565b810181811067ffffffffffffffff8211171561052b5761052a6104d6565b5b80604052505050565b5f61053d6104ad565b90506105498282610503565b919050565b5f67ffffffffffffffff821115610568576105676104d6565b5b610571826104c6565b9050602081019050919050565b828183375f83830152505050565b5f61059e6105998461054e565b610534565b9050828152602081018484840111156105ba576105b96104c2565b5b6105c584828561057e565b509392505050565b5f82601f8301126105e1576105e06104be565b5b81356105f184826020860161058c565b91505092915050565b5f6020828403121561060f5761060e6104b6565b5b5f82013567ffffffffffffffff81111561062c5761062b6104ba565b5b610638848285016105cd565b91505092915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f61066a82610641565b9050919050565b61067a81610660565b82525050565b5f6020820190506106935f830184610671565b92915050565b6106a281610660565b81146106ac575f80fd5b50565b5f813590506106bd81610699565b92915050565b5f80604083850312156106d9576106d86104b6565b5b5f6106e6858286016106af565b925050602083013567ffffffffffffffff811115610707576107066104ba565b5b610713858286016105cd565b9150509250929050565b5f82825260208201905092915050565b7f4574686572206465706f736974207265717569726564000000000000000000005f82015250565b5f61076160168361071d565b915061076c8261072d565b602082019050919050565b5f6020820190508181035f83015261078e81610755565b9050919050565b5f81519050919050565b5f81905092915050565b8281835e5f83830152505050565b5f6107c182610795565b6107cb818561079f565b93506107db8185602086016107a9565b80840191505092915050565b5f6107f282846107b7565b915081905092915050565b5f819050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f61083d826107fd565b9150610848836107fd565b92508282019050808211156108605761085f610806565b5b92915050565b7f4e6f20766f7465722e00000000000000000000000000000000000000000000005f82015250565b5f61089a60098361071d565b91506108a582610866565b602082019050919050565b5f6020820190508181035f8301526108c78161088e565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601260045260245ffd5b5f610905826107fd565b9150610910836107fd565b9250826109205761091f6108ce565b5b828204905092915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52603260045260245ffd5b7f496e76616c696420616464726573732e000000000000000000000000000000005f82015250565b5f61098c60108361071d565b915061099782610958565b602082019050919050565b5f6020820190508181035f8301526109b981610980565b905091905056fea26469706673582212203b8cddbe19548818dd7cc5539d742d96812ba5ec92fd4c3accfd32edf5a92ae964736f6c63430008190033";

    public static final String FUNC_ADDVOTER = "addVoter";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SENDMESSAGE = "sendMessage";

    public static final String FUNC_SHAREETHER = "shareEther";

    @Deprecated
    protected TransferToken2_sol_transferToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferToken2_sol_transferToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TransferToken2_sol_transferToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TransferToken2_sol_transferToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addVoter(String voterAddress, String email) {
        final Function function = new Function(
                FUNC_ADDVOTER, 
                Arrays.<Type>asList(new Address(160, voterAddress),
                new org.web3j.abi.datatypes.Utf8String(email)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> sendMessage(String email, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SENDMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> shareEther(String email) {
        final Function function = new Function(
                FUNC_SHAREETHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TransferToken2_sol_transferToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferToken2_sol_transferToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TransferToken2_sol_transferToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferToken2_sol_transferToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TransferToken2_sol_transferToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TransferToken2_sol_transferToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TransferToken2_sol_transferToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TransferToken2_sol_transferToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TransferToken2_sol_transferToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TransferToken2_sol_transferToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TransferToken2_sol_transferToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TransferToken2_sol_transferToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TransferToken2_sol_transferToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferToken2_sol_transferToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TransferToken2_sol_transferToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferToken2_sol_transferToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
