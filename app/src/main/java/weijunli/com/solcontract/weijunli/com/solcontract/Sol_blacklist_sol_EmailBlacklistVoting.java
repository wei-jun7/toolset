package weijunli.com.solcontract.weijunli.com.solcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
 * <p>Generated with web3j version 1.5.3.
 */
@SuppressWarnings("rawtypes")
public class Sol_blacklist_sol_EmailBlacklistVoting extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b505f80546001600160a01b03191633179055610ad28061002d5f395ff3fe608060405234801561000f575f80fd5b50600436106100a6575f3560e01c806398fc26b41161006e57806398fc26b414610146578063a438d2081461014e578063aadc3b7214610158578063d6b2883314610195578063fe8eee4c146101b4578063ff626727146101c7575f80fd5b80630bec5a85146100aa578063199edd7a146100d3578063328c8649146100e85780637a7cfa4d146101095780638da5cb5b1461011c575b5f80fd5b6100bd6100b8366004610749565b6101da565b6040516100ca919061077b565b60405180910390f35b6100e66100e13660046107c4565b6102a6565b005b6100fb6100f6366004610749565b610489565b6040519081526020016100ca565b6100e6610117366004610749565b610525565b5f5461012e906001600160a01b031681565b6040516001600160a01b0390911681526020016100ca565b6100fb600381565b6100fb6203f48081565b61018561016636600461080f565b600260209081525f928352604080842090915290825290205460ff1681565b60405190151581526020016100ca565b6100fb6101a3366004610848565b60066020525f908152604090205481565b6100e66101c236600461085f565b6105c5565b6101856101d5366004610749565b61066b565b60605f826040516020016101ee91906108ce565b60405160208183030381529060405280519060200120905060055f8281526020019081526020015f208054610222906108e4565b80601f016020809104026020016040519081016040528092919081815260200182805461024e906108e4565b80156102995780601f1061027057610100808354040283529160200191610299565b820191905f5260205f20905b81548152906001019060200180831161027c57829003601f168201915b5050505050915050919050565b5f826040516020016102b891906108ce565b60408051601f1981840301815291815281516020928301205f81815260069093529120549091504211156103285760405162461bcd60e51b81526020600482015260126024820152712b37ba34b733903832b934b7b21037bb32b960711b60448201526064015b60405180910390fd5b5f81815260026020908152604080832033845290915290205460ff16156103815760405162461bcd60e51b815260206004820152600d60248201526c105b1c9958591e481d9bdd1959609a1b604482015260640161031f565b8115610443575f8181526003602052604081208054916103a083610930565b90915550505f81815260036020819052604090912054108015906103ff57505f818152600460209081526040808320546003909252909120546002916103e591610948565b6103ef9190610961565b5f82815260036020526040902054115b1561043e575f818152600160209081526040808320805460ff191690558051808301825283815284845260059092529091209061043c90826109c9565b505b610462565b5f81815260046020526040812080549161045c83610930565b91905055505b5f9081526002602090815260408083203384529091529020805460ff191660011790555050565b5f808260405160200161049c91906108ce565b60408051601f1981840301815291815281516020928301205f818152600393849052919091205490925090811080159061050457505f828152600460209081526040808320546003909252909120546002916104f791610948565b6105019190610961565b81115b1561051257505f9392505050565b61051d816003610a89565b949350505050565b5f8160405160200161053791906108ce565b60408051601f1981840301815291815281516020928301205f818152600190935291205490915060ff166105a65760405162461bcd60e51b8152602060048201526016602482015275115b585a5b081b9bdd081a5b88189b1858dadb1a5cdd60521b604482015260640161031f565b6105b36203f48042610948565b5f918252600660205260409091205550565b5f546001600160a01b0316331461060f5760405162461bcd60e51b815260206004820152600e60248201526d139bdd08185d5d1a1bdc9a5e995960921b604482015260640161031f565b5f8360405160200161062191906108ce565b60408051808303601f1901815291815281516020928301205f81815260018452828120805460ff19168815151790556005909352912090915061066483826109c9565b5050505050565b5f808260405160200161067e91906108ce565b60408051601f1981840301815291815281516020928301205f908152600190925290205460ff169392505050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f8301126106cf575f80fd5b813567ffffffffffffffff808211156106ea576106ea6106ac565b604051601f8301601f19908116603f01168101908282118183101715610712576107126106ac565b8160405283815286602085880101111561072a575f80fd5b836020870160208301375f602085830101528094505050505092915050565b5f60208284031215610759575f80fd5b813567ffffffffffffffff81111561076f575f80fd5b61051d848285016106c0565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b803580151581146107bf575f80fd5b919050565b5f80604083850312156107d5575f80fd5b823567ffffffffffffffff8111156107eb575f80fd5b6107f7858286016106c0565b925050610806602084016107b0565b90509250929050565b5f8060408385031215610820575f80fd5b8235915060208301356001600160a01b038116811461083d575f80fd5b809150509250929050565b5f60208284031215610858575f80fd5b5035919050565b5f805f60608486031215610871575f80fd5b833567ffffffffffffffff80821115610888575f80fd5b610894878388016106c0565b94506108a2602087016107b0565b935060408601359150808211156108b7575f80fd5b506108c4868287016106c0565b9150509250925092565b5f82518060208501845e5f920191825250919050565b600181811c908216806108f857607f821691505b60208210810361091657634e487b7160e01b5f52602260045260245ffd5b50919050565b634e487b7160e01b5f52601160045260245ffd5b5f600182016109415761094161091c565b5060010190565b8082018082111561095b5761095b61091c565b92915050565b5f8261097b57634e487b7160e01b5f52601260045260245ffd5b500490565b601f8211156109c457805f5260205f20601f840160051c810160208510156109a55750805b601f840160051c820191505b81811015610664575f81556001016109b1565b505050565b815167ffffffffffffffff8111156109e3576109e36106ac565b6109f7816109f184546108e4565b84610980565b602080601f831160018114610a2a575f8415610a135750858301515b5f19600386901b1c1916600185901b178555610a81565b5f85815260208120601f198616915b82811015610a5857888601518255948401946001909101908401610a39565b5085821015610a7557878501515f19600388901b60f8161c191681555b505060018460011b0185555b505050505050565b8181038181111561095b5761095b61091c56fea2646970667358221220c77a44891c149d00edb1b801d194855c613651f35e611972554ca5f93982838764736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_VOTES_REQUIRED_FOR_REMOVAL = "VOTES_REQUIRED_FOR_REMOVAL";

    public static final String FUNC_VOTING_DURATION = "VOTING_DURATION";

    public static final String FUNC_CASTVOTE = "castVote";

    public static final String FUNC_GETEMAILCONTENTHASH = "getEmailContentHash";

    public static final String FUNC_HASVOTED = "hasVoted";

    public static final String FUNC_INITIATEVOTE = "initiateVote";

    public static final String FUNC_ISBLACKLISTED = "isBlacklisted";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETBLACKLISTSTATUS = "setBlacklistStatus";

    public static final String FUNC_VOTEENDTIME = "voteEndTime";

    public static final String FUNC_VOTESNEEDED = "votesNeeded";

    @Deprecated
    protected Sol_blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sol_blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Sol_blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Sol_blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> VOTES_REQUIRED_FOR_REMOVAL() {
        final Function function = new Function(FUNC_VOTES_REQUIRED_FOR_REMOVAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> VOTING_DURATION() {
        final Function function = new Function(FUNC_VOTING_DURATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> castVote(String email, Boolean voteToRemove) {
        final Function function = new Function(
                FUNC_CASTVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email), 
                new org.web3j.abi.datatypes.Bool(voteToRemove)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getEmailContentHash(String email) {
        final Function function = new Function(FUNC_GETEMAILCONTENTHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> hasVoted(byte[] param0, String param1) {
        final Function function = new Function(FUNC_HASVOTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0), 
                new org.web3j.abi.datatypes.Address(160, param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initiateVote(String email) {
        final Function function = new Function(
                FUNC_INITIATEVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isBlacklisted(String email) {
        final Function function = new Function(FUNC_ISBLACKLISTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBlacklistStatus(String email, Boolean status, String ipfsHash) {
        final Function function = new Function(
                FUNC_SETBLACKLISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email), 
                new org.web3j.abi.datatypes.Bool(status), 
                new org.web3j.abi.datatypes.Utf8String(ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> voteEndTime(byte[] param0) {
        final Function function = new Function(FUNC_VOTEENDTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> votesNeeded(String email) {
        final Function function = new Function(FUNC_VOTESNEEDED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Sol_blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sol_blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Sol_blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sol_blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Sol_blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Sol_blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Sol_blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Sol_blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Sol_blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Sol_blacklist_sol_EmailBlacklistVoting.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<Sol_blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Sol_blacklist_sol_EmailBlacklistVoting.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Sol_blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sol_blacklist_sol_EmailBlacklistVoting.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Sol_blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sol_blacklist_sol_EmailBlacklistVoting.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }



    public static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
