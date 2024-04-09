package weijunli.com.solcontract.weijunli;

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
public class BlackList_sol_EmailBlacklistVoting extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b505f80546001600160a01b03191633179055610b348061002d5f395ff3fe608060405234801561000f575f80fd5b50600436106100b1575f3560e01c806398fc26b41161006e57806398fc26b414610164578063a438d2081461016c578063aadc3b7214610176578063c53869bf146101b3578063d6b28833146101c6578063ff626727146101e5575f80fd5b80630bec5a85146100b5578063199edd7a146100de578063328c8649146100f35780637a7cfa4d146101145780638da5cb5b1461012757806398619dcf14610151575b5f80fd5b6100c86100c33660046107ce565b6101f8565b6040516100d59190610800565b60405180910390f35b6100f16100ec366004610835565b6102c4565b005b6101066101013660046107ce565b61048f565b6040519081526020016100d5565b6100f16101223660046107ce565b61052b565b5f54610139906001600160a01b031681565b6040516001600160a01b0390911681526020016100d5565b6100f161015f366004610835565b6105cb565b610106600381565b6101066203f48081565b6101a3610184366004610888565b600260209081525f928352604080842090915290825290205460ff1681565b60405190151581526020016100d5565b6100f16101c13660046108b6565b61065e565b6101066101d4366004610916565b60066020525f908152604090205481565b6101a36101f33660046107ce565b6106f0565b60605f8260405160200161020c919061092d565b60405160208183030381529060405280519060200120905060055f8281526020019081526020015f20805461024090610943565b80601f016020809104026020016040519081016040528092919081815260200182805461026c90610943565b80156102b75780601f1061028e576101008083540402835291602001916102b7565b820191905f5260205f20905b81548152906001019060200180831161029a57829003601f168201915b5050505050915050919050565b5f826040516020016102d6919061092d565b60408051601f1981840301815291815281516020928301205f81815260069093529120549091504211156103465760405162461bcd60e51b81526020600482015260126024820152712b37ba34b733903832b934b7b21037bb32b960711b60448201526064015b60405180910390fd5b5f81815260026020908152604080832033845290915290205460ff161561039f5760405162461bcd60e51b815260206004820152600d60248201526c105b1c9958591e481d9bdd1959609a1b604482015260640161033d565b5f8181526004602090815260408083205460039092528220546103c2919061098f565b6103cd90600161098f565b90508215610448575f8281526003602052604081208054916103ee836109a8565b90915550505f828152600360208190526040909120541080159061042857506104186002826109c0565b5f83815260036020526040902054115b15610443575f828152600160205260409020805460ff191690555b610467565b5f828152600460205260408120805491610461836109a8565b91905055505b505f9081526002602090815260408083203384529091529020805460ff191660011790555050565b5f80826040516020016104a2919061092d565b60408051601f1981840301815291815281516020928301205f818152600393849052919091205490925090811080159061050a57505f828152600460209081526040808320546003909252909120546002916104fd9161098f565b61050791906109c0565b81115b1561051857505f9392505050565b6105238160036109df565b949350505050565b5f8160405160200161053d919061092d565b60408051601f1981840301815291815281516020928301205f818152600190935291205490915060ff166105ac5760405162461bcd60e51b8152602060048201526016602482015275115b585a5b081b9bdd081a5b88189b1858dadb1a5cdd60521b604482015260640161033d565b6105b96203f4804261098f565b5f918252600660205260409091205550565b5f546001600160a01b031633146106155760405162461bcd60e51b815260206004820152600e60248201526d139bdd08185d5d1a1bdc9a5e995960921b604482015260640161033d565b5f82604051602001610627919061092d565b60408051808303601f1901815291815281516020928301205f90815260019092529020805460ff1916921515929092179091555050565b5f546001600160a01b031633146106a85760405162461bcd60e51b815260206004820152600e60248201526d139bdd08185d5d1a1bdc9a5e995960921b604482015260640161033d565b5f826040516020016106ba919061092d565b60408051601f1981840301815291815281516020928301205f818152600590935291209091506106ea8382610a3e565b50505050565b5f8082604051602001610703919061092d565b60408051601f1981840301815291815281516020928301205f908152600190925290205460ff169392505050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f830112610754575f80fd5b813567ffffffffffffffff8082111561076f5761076f610731565b604051601f8301601f19908116603f0116810190828211818310171561079757610797610731565b816040528381528660208588010111156107af575f80fd5b836020870160208301375f602085830101528094505050505092915050565b5f602082840312156107de575f80fd5b813567ffffffffffffffff8111156107f4575f80fd5b61052384828501610745565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b5f8060408385031215610846575f80fd5b823567ffffffffffffffff81111561085c575f80fd5b61086885828601610745565b9250506020830135801515811461087d575f80fd5b809150509250929050565b5f8060408385031215610899575f80fd5b8235915060208301356001600160a01b038116811461087d575f80fd5b5f80604083850312156108c7575f80fd5b823567ffffffffffffffff808211156108de575f80fd5b6108ea86838701610745565b935060208501359150808211156108ff575f80fd5b5061090c85828601610745565b9150509250929050565b5f60208284031215610926575f80fd5b5035919050565b5f82518060208501845e5f920191825250919050565b600181811c9082168061095757607f821691505b60208210810361097557634e487b7160e01b5f52602260045260245ffd5b50919050565b634e487b7160e01b5f52601160045260245ffd5b808201808211156109a2576109a261097b565b92915050565b5f600182016109b9576109b961097b565b5060010190565b5f826109da57634e487b7160e01b5f52601260045260245ffd5b500490565b818103818111156109a2576109a261097b565b601f821115610a3957805f5260205f20601f840160051c81016020851015610a175750805b601f840160051c820191505b81811015610a36575f8155600101610a23565b50505b505050565b815167ffffffffffffffff811115610a5857610a58610731565b610a6c81610a668454610943565b846109f2565b602080601f831160018114610a9f575f8415610a885750858301515b5f19600386901b1c1916600185901b178555610af6565b5f85815260208120601f198616915b82811015610acd57888601518255948401946001909101908401610aae565b5085821015610aea57878501515f19600388901b60f8161c191681555b505060018460011b0185555b50505050505056fea2646970667358221220663f18d45ec92d991cf158a5a98671b27871b9a2c62d122d33219506908a44cb64736f6c63430008190033";

    public static final String FUNC_VOTES_REQUIRED_FOR_REMOVAL = "VOTES_REQUIRED_FOR_REMOVAL";

    public static final String FUNC_VOTING_DURATION = "VOTING_DURATION";

    public static final String FUNC_ADDEMAILCONTENTHASH = "addEmailContentHash";

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
    protected BlackList_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BlackList_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BlackList_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BlackList_sol_EmailBlacklistVoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> addEmailContentHash(String email, String ipfsHash) {
        final Function function = new Function(
                FUNC_ADDEMAILCONTENTHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email), 
                new org.web3j.abi.datatypes.Utf8String(ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteFunctionCall<TransactionReceipt> setBlacklistStatus(String email, Boolean status) {
        final Function function = new Function(
                FUNC_SETBLACKLISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(email), 
                new org.web3j.abi.datatypes.Bool(status)), 
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
    public static BlackList_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlackList_sol_EmailBlacklistVoting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BlackList_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlackList_sol_EmailBlacklistVoting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BlackList_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BlackList_sol_EmailBlacklistVoting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BlackList_sol_EmailBlacklistVoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BlackList_sol_EmailBlacklistVoting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BlackList_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlackList_sol_EmailBlacklistVoting.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<BlackList_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlackList_sol_EmailBlacklistVoting.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BlackList_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlackList_sol_EmailBlacklistVoting.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BlackList_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlackList_sol_EmailBlacklistVoting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
