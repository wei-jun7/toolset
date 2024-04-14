package weijunli.com.solcontract.weijunli.com.solcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public class Blacklist_sol_EmailBlacklistVoting extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b505f80546001600160a01b03191633179055610bae8061002d5f395ff3fe608060405234801561000f575f80fd5b50600436106100cb575f3560e01c806398fc26b411610088578063d6b2883311610063578063d6b28833146101c2578063fa5f4e39146101e1578063fe8eee4c146101f4578063ff62672714610207575f80fd5b806398fc26b414610173578063a438d2081461017b578063aadc3b7214610185575f80fd5b80630bec5a85146100cf578063199edd7a146100f8578063328c86491461010d5780637a7cfa4d1461012e5780638da5cb5b1461014157806398bb4afe1461016b575b5f80fd5b6100e26100dd366004610825565b61021a565b6040516100ef9190610857565b60405180910390f35b61010b6101063660046108a0565b6102e6565b005b61012061011b366004610825565b6104c9565b6040519081526020016100ef565b61010b61013c366004610825565b610565565b5f54610153906001600160a01b031681565b6040516001600160a01b0390911681526020016100ef565b6100e2610605565b610120600381565b6101206203f48081565b6101b26101933660046108eb565b600260209081525f928352604080842090915290825290205460ff1681565b60405190151581526020016100ef565b6101206101d0366004610924565b60076020525f908152604090205481565b61010b6101ef366004610825565b610691565b61010b61020236600461093b565b6106a1565b6101b2610215366004610825565b610747565b60605f8260405160200161022e91906109aa565b60405160208183030381529060405280519060200120905060055f8281526020019081526020015f208054610262906109c0565b80601f016020809104026020016040519081016040528092919081815260200182805461028e906109c0565b80156102d95780601f106102b0576101008083540402835291602001916102d9565b820191905f5260205f20905b8154815290600101906020018083116102bc57829003601f168201915b5050505050915050919050565b5f826040516020016102f891906109aa565b60408051601f1981840301815291815281516020928301205f81815260079093529120549091504211156103685760405162461bcd60e51b81526020600482015260126024820152712b37ba34b733903832b934b7b21037bb32b960711b60448201526064015b60405180910390fd5b5f81815260026020908152604080832033845290915290205460ff16156103c15760405162461bcd60e51b815260206004820152600d60248201526c105b1c9958591e481d9bdd1959609a1b604482015260640161035f565b8115610483575f8181526003602052604081208054916103e083610a0c565b90915550505f818152600360208190526040909120541080159061043f57505f8181526004602090815260408083205460039092529091205460029161042591610a24565b61042f9190610a3d565b5f82815260036020526040902054115b1561047e575f818152600160209081526040808320805460ff191690558051808301825283815284845260059092529091209061047c9082610aa5565b505b6104a2565b5f81815260046020526040812080549161049c83610a0c565b91905055505b5f9081526002602090815260408083203384529091529020805460ff191660011790555050565b5f80826040516020016104dc91906109aa565b60408051601f1981840301815291815281516020928301205f818152600393849052919091205490925090811080159061054457505f8281526004602090815260408083205460039092529091205460029161053791610a24565b6105419190610a3d565b81115b1561055257505f9392505050565b61055d816003610b65565b949350505050565b5f8160405160200161057791906109aa565b60408051601f1981840301815291815281516020928301205f818152600190935291205490915060ff166105e65760405162461bcd60e51b8152602060048201526016602482015275115b585a5b081b9bdd081a5b88189b1858dadb1a5cdd60521b604482015260640161035f565b6105f36203f48042610a24565b5f918252600760205260409091205550565b60068054610612906109c0565b80601f016020809104026020016040519081016040528092919081815260200182805461063e906109c0565b80156106895780601f1061066057610100808354040283529160200191610689565b820191905f5260205f20905b81548152906001019060200180831161066c57829003601f168201915b505050505081565b600661069d8282610aa5565b5050565b5f546001600160a01b031633146106eb5760405162461bcd60e51b815260206004820152600e60248201526d139bdd08185d5d1a1bdc9a5e995960921b604482015260640161035f565b5f836040516020016106fd91906109aa565b60408051808303601f1901815291815281516020928301205f81815260018452828120805460ff1916881515179055600590935291209091506107408382610aa5565b5050505050565b5f808260405160200161075a91906109aa565b60408051601f1981840301815291815281516020928301205f908152600190925290205460ff169392505050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f8301126107ab575f80fd5b813567ffffffffffffffff808211156107c6576107c6610788565b604051601f8301601f19908116603f011681019082821181831017156107ee576107ee610788565b81604052838152866020858801011115610806575f80fd5b836020870160208301375f602085830101528094505050505092915050565b5f60208284031215610835575f80fd5b813567ffffffffffffffff81111561084b575f80fd5b61055d8482850161079c565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b8035801515811461089b575f80fd5b919050565b5f80604083850312156108b1575f80fd5b823567ffffffffffffffff8111156108c7575f80fd5b6108d38582860161079c565b9250506108e26020840161088c565b90509250929050565b5f80604083850312156108fc575f80fd5b8235915060208301356001600160a01b0381168114610919575f80fd5b809150509250929050565b5f60208284031215610934575f80fd5b5035919050565b5f805f6060848603121561094d575f80fd5b833567ffffffffffffffff80821115610964575f80fd5b6109708783880161079c565b945061097e6020870161088c565b93506040860135915080821115610993575f80fd5b506109a08682870161079c565b9150509250925092565b5f82518060208501845e5f920191825250919050565b600181811c908216806109d457607f821691505b6020821081036109f257634e487b7160e01b5f52602260045260245ffd5b50919050565b634e487b7160e01b5f52601160045260245ffd5b5f60018201610a1d57610a1d6109f8565b5060010190565b80820180821115610a3757610a376109f8565b92915050565b5f82610a5757634e487b7160e01b5f52601260045260245ffd5b500490565b601f821115610aa057805f5260205f20601f840160051c81016020851015610a815750805b601f840160051c820191505b81811015610740575f8155600101610a8d565b505050565b815167ffffffffffffffff811115610abf57610abf610788565b610ad381610acd84546109c0565b84610a5c565b602080601f831160018114610b06575f8415610aef5750858301515b5f19600386901b1c1916600185901b178555610b5d565b5f85815260208120601f198616915b82811015610b3457888601518255948401946001909101908401610b15565b5085821015610b5157878501515f19600388901b60f8161c191681555b505060018460011b0185555b505050505050565b81810381811115610a3757610a376109f856fea264697066735822122047e4a98b54116a5f3e8d9ae2e8aa77eb41fcbfeaad0920ae4fa032faadbdeadd64736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_VOTES_REQUIRED_FOR_REMOVAL = "VOTES_REQUIRED_FOR_REMOVAL";

    public static final String FUNC_VOTING_DURATION = "VOTING_DURATION";

    public static final String FUNC_CASTVOTE = "castVote";

    public static final String FUNC_GETEMAILCONTENTHASH = "getEmailContentHash";

    public static final String FUNC_HASVOTED = "hasVoted";

    public static final String FUNC_INITIATEVOTE = "initiateVote";

    public static final String FUNC_ISBLACKLISTED = "isBlacklisted";

    public static final String FUNC_LATESTBLACKLISTCID = "latestBlacklistCid";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETBLACKLISTSTATUS = "setBlacklistStatus";

    public static final String FUNC_UPDATEBLACKLISTCID = "updateBlacklistCid";

    public static final String FUNC_VOTEENDTIME = "voteEndTime";

    public static final String FUNC_VOTESNEEDED = "votesNeeded";

    @Deprecated
    protected Blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Blacklist_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<String> latestBlacklistCid() {
        final Function function = new Function(FUNC_LATESTBLACKLISTCID, 
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

    public RemoteFunctionCall<TransactionReceipt> setBlacklistStatus(String email, Boolean status, String ipfsHash) {
        final Function function = new Function(
                FUNC_SETBLACKLISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email), 
                new org.web3j.abi.datatypes.Bool(status), 
                new org.web3j.abi.datatypes.Utf8String(ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateBlacklistCid(String _newCid) {
        final Function function = new Function(
                FUNC_UPDATEBLACKLISTCID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_newCid)), 
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
    public static Blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Blacklist_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Blacklist_sol_EmailBlacklistVoting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
