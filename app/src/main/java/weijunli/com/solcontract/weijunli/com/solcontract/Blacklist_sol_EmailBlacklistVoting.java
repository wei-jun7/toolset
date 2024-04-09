package weijunli.com.solcontract.weijunli.com.solcontract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class Blacklist_sol_EmailBlacklistVoting extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b50335f806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506115968061005b5f395ff3fe608060405234801561000f575f80fd5b50600436106100b2575f3560e01c806398fc26b41161006f57806398fc26b414610188578063a438d208146101a6578063aadc3b72146101c4578063c53869bf146101f4578063d6b2883314610210578063ff62672714610240576100b2565b80630bec5a85146100b6578063199edd7a146100e6578063328c8649146101025780637a7cfa4d146101325780638da5cb5b1461014e57806398619dcf1461016c575b5f80fd5b6100d060048036038101906100cb9190610c06565b610270565b6040516100dd9190610cad565b60405180910390f35b61010060048036038101906100fb9190610d02565b61033c565b005b61011c60048036038101906101179190610c06565b610624565b6040516101299190610d74565b60405180910390f35b61014c60048036038101906101479190610c06565b6106d3565b005b6101566107cb565b6040516101639190610dcc565b60405180910390f35b61018660048036038101906101819190610d02565b6107ee565b005b61019061090a565b60405161019d9190610d74565b60405180910390f35b6101ae61090f565b6040516101bb9190610d74565b60405180910390f35b6101de60048036038101906101d99190610e42565b610916565b6040516101eb9190610e8f565b60405180910390f35b61020e60048036038101906102099190610ea8565b610940565b005b61022a60048036038101906102259190610f1e565b610a53565b6040516102379190610d74565b60405180910390f35b61025a60048036038101906102559190610c06565b610a68565b6040516102679190610e8f565b60405180910390f35b60605f826040516020016102849190610f83565b60405160208183030381529060405280519060200120905060055f8281526020019081526020015f2080546102b890610fc6565b80601f01602080910402602001604051908101604052809291908181526020018280546102e490610fc6565b801561032f5780601f106103065761010080835404028352916020019161032f565b820191905f5260205f20905b81548152906001019060200180831161031257829003601f168201915b5050505050915050919050565b5f8260405160200161034e9190610f83565b60405160208183030381529060405280519060200120905060065f8281526020019081526020015f20544211156103ba576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103b190611040565b60405180910390fd5b60025f8281526020019081526020015f205f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f9054906101000a900460ff1615610453576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161044a906110a8565b60405180910390fd5b5f600160045f8481526020019081526020015f205460035f8581526020019081526020015f205461048491906110f3565b61048e91906110f3565b905082156105595760035f8381526020019081526020015f205f8154809291906104b790611126565b91905055506003805f8481526020019081526020015f2054101580156104f957506002816104e5919061119a565b60035f8481526020019081526020015f2054115b15610554575f60015f8481526020019081526020015f205f6101000a81548160ff021916908315150217905550817f5be1b55e27a0b11af8f5274ded9dcafc71d65f9ab79463af695265892cc104f560405160405180910390a25b610580565b60045f8381526020019081526020015f205f81548092919061057a90611126565b91905055505b600160025f8481526020019081526020015f205f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f6101000a81548160ff021916908315150217905550817fcb73b4bccbde48058d090b6a045e712b675995c78cc1d9c587cd779742e0136c33856040516106169291906111ca565b60405180910390a250505050565b5f80826040516020016106379190610f83565b6040516020818303038152906040528051906020012090505f60035f8381526020019081526020015f20549050600381101580156106ad5750600260045f8481526020019081526020015f205460035f8581526020019081526020015f20546106a091906110f3565b6106aa919061119a565b81115b156106bc575f925050506106ce565b8060036106c991906111f1565b925050505b919050565b5f816040516020016106e59190610f83565b60405160208183030381529060405280519060200120905060015f8281526020019081526020015f205f9054906101000a900460ff1661075a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107519061126e565b60405180910390fd5b6203f4804261076991906110f3565b60065f8381526020019081526020015f2081905550807fcc472bb423f16c1983db969fc32c014570a969eb00f9f65b3e043683f741ee3460065f8481526020019081526020015f20546040516107bf9190610d74565b60405180910390a25050565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461087b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610872906112d6565b60405180910390fd5b5f8260405160200161088d9190610f83565b6040516020818303038152906040528051906020012090508160015f8381526020019081526020015f205f6101000a81548160ff021916908315150217905550807fd84919504ca8999bf3c6ebcaab45284c343fcff743160b2e0d545d65070d6240836040516108fd9190610e8f565b60405180910390a2505050565b600381565b6203f48081565b6002602052815f5260405f20602052805f5260405f205f915091509054906101000a900460ff1681565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146109cd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109c4906112d6565b60405180910390fd5b5f826040516020016109df9190610f83565b6040516020818303038152906040528051906020012090508160055f8381526020019081526020015f209081610a159190611491565b50807fb9b57ee66b6415f78faf36d9c59bc7c5c98fae6e76e6d279fd21acf8a0aba54483604051610a469190610cad565b60405180910390a2505050565b6006602052805f5260405f205f915090505481565b5f8082604051602001610a7b9190610f83565b60405160208183030381529060405280519060200120905060015f8281526020019081526020015f205f9054906101000a900460ff16915050919050565b5f604051905090565b5f80fd5b5f80fd5b5f80fd5b5f80fd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b610b1882610ad2565b810181811067ffffffffffffffff82111715610b3757610b36610ae2565b5b80604052505050565b5f610b49610ab9565b9050610b558282610b0f565b919050565b5f67ffffffffffffffff821115610b7457610b73610ae2565b5b610b7d82610ad2565b9050602081019050919050565b828183375f83830152505050565b5f610baa610ba584610b5a565b610b40565b905082815260208101848484011115610bc657610bc5610ace565b5b610bd1848285610b8a565b509392505050565b5f82601f830112610bed57610bec610aca565b5b8135610bfd848260208601610b98565b91505092915050565b5f60208284031215610c1b57610c1a610ac2565b5b5f82013567ffffffffffffffff811115610c3857610c37610ac6565b5b610c4484828501610bd9565b91505092915050565b5f81519050919050565b5f82825260208201905092915050565b8281835e5f83830152505050565b5f610c7f82610c4d565b610c898185610c57565b9350610c99818560208601610c67565b610ca281610ad2565b840191505092915050565b5f6020820190508181035f830152610cc58184610c75565b905092915050565b5f8115159050919050565b610ce181610ccd565b8114610ceb575f80fd5b50565b5f81359050610cfc81610cd8565b92915050565b5f8060408385031215610d1857610d17610ac2565b5b5f83013567ffffffffffffffff811115610d3557610d34610ac6565b5b610d4185828601610bd9565b9250506020610d5285828601610cee565b9150509250929050565b5f819050919050565b610d6e81610d5c565b82525050565b5f602082019050610d875f830184610d65565b92915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f610db682610d8d565b9050919050565b610dc681610dac565b82525050565b5f602082019050610ddf5f830184610dbd565b92915050565b5f819050919050565b610df781610de5565b8114610e01575f80fd5b50565b5f81359050610e1281610dee565b92915050565b610e2181610dac565b8114610e2b575f80fd5b50565b5f81359050610e3c81610e18565b92915050565b5f8060408385031215610e5857610e57610ac2565b5b5f610e6585828601610e04565b9250506020610e7685828601610e2e565b9150509250929050565b610e8981610ccd565b82525050565b5f602082019050610ea25f830184610e80565b92915050565b5f8060408385031215610ebe57610ebd610ac2565b5b5f83013567ffffffffffffffff811115610edb57610eda610ac6565b5b610ee785828601610bd9565b925050602083013567ffffffffffffffff811115610f0857610f07610ac6565b5b610f1485828601610bd9565b9150509250929050565b5f60208284031215610f3357610f32610ac2565b5b5f610f4084828501610e04565b91505092915050565b5f81905092915050565b5f610f5d82610c4d565b610f678185610f49565b9350610f77818560208601610c67565b80840191505092915050565b5f610f8e8284610f53565b915081905092915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f6002820490506001821680610fdd57607f821691505b602082108103610ff057610fef610f99565b5b50919050565b7f566f74696e6720706572696f64206f76657200000000000000000000000000005f82015250565b5f61102a601283610c57565b915061103582610ff6565b602082019050919050565b5f6020820190508181035f8301526110578161101e565b9050919050565b7f416c726561647920766f746564000000000000000000000000000000000000005f82015250565b5f611092600d83610c57565b915061109d8261105e565b602082019050919050565b5f6020820190508181035f8301526110bf81611086565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f6110fd82610d5c565b915061110883610d5c565b92508282019050808211156111205761111f6110c6565b5b92915050565b5f61113082610d5c565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203611162576111616110c6565b5b600182019050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601260045260245ffd5b5f6111a482610d5c565b91506111af83610d5c565b9250826111bf576111be61116d565b5b828204905092915050565b5f6040820190506111dd5f830185610dbd565b6111ea6020830184610e80565b9392505050565b5f6111fb82610d5c565b915061120683610d5c565b925082820390508181111561121e5761121d6110c6565b5b92915050565b7f456d61696c206e6f7420696e20626c61636b6c697374000000000000000000005f82015250565b5f611258601683610c57565b915061126382611224565b602082019050919050565b5f6020820190508181035f8301526112858161124c565b9050919050565b7f4e6f7420617574686f72697a65640000000000000000000000000000000000005f82015250565b5f6112c0600e83610c57565b91506112cb8261128c565b602082019050919050565b5f6020820190508181035f8301526112ed816112b4565b9050919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026113507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82611315565b61135a8683611315565b95508019841693508086168417925050509392505050565b5f819050919050565b5f61139561139061138b84610d5c565b611372565b610d5c565b9050919050565b5f819050919050565b6113ae8361137b565b6113c26113ba8261139c565b848454611321565b825550505050565b5f90565b6113d66113ca565b6113e18184846113a5565b505050565b5b81811015611404576113f95f826113ce565b6001810190506113e7565b5050565b601f8211156114495761141a816112f4565b61142384611306565b81016020851015611432578190505b61144661143e85611306565b8301826113e6565b50505b505050565b5f82821c905092915050565b5f6114695f198460080261144e565b1980831691505092915050565b5f611481838361145a565b9150826002028217905092915050565b61149a82610c4d565b67ffffffffffffffff8111156114b3576114b2610ae2565b5b6114bd8254610fc6565b6114c8828285611408565b5f60209050601f8311600181146114f9575f84156114e7578287015190505b6114f18582611476565b865550611558565b601f198416611507866112f4565b5f5b8281101561152e57848901518255600182019150602085019450602081019050611509565b8683101561154b5784890151611547601f89168261145a565b8355505b6001600288020188555050505b50505050505056fea2646970667358221220793a7acba1b7665c2b05e371732371784f4b56f6c705a33d6be5fe49692418e064736f6c63430008190033";

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

    public static final Event EMAILBLACKLISTED_EVENT = new Event("EmailBlacklisted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event EMAILCONTENTADDED_EVENT = new Event("EmailContentAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event EMAILREMOVEDFROMBLACKLIST_EVENT = new Event("EmailRemovedFromBlacklist", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event VOTECASTED_EVENT = new Event("VoteCasted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event VOTEINITIATED_EVENT = new Event("VoteInitiated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>() {}));
    ;

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

    public static List<EmailBlacklistedEventResponse> getEmailBlacklistedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EMAILBLACKLISTED_EVENT, transactionReceipt);
        ArrayList<EmailBlacklistedEventResponse> responses = new ArrayList<EmailBlacklistedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EmailBlacklistedEventResponse typedResponse = new EmailBlacklistedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EmailBlacklistedEventResponse getEmailBlacklistedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EMAILBLACKLISTED_EVENT, log);
        EmailBlacklistedEventResponse typedResponse = new EmailBlacklistedEventResponse();
        typedResponse.log = log;
        typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<EmailBlacklistedEventResponse> emailBlacklistedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEmailBlacklistedEventFromLog(log));
    }

    public Flowable<EmailBlacklistedEventResponse> emailBlacklistedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EMAILBLACKLISTED_EVENT));
        return emailBlacklistedEventFlowable(filter);
    }

    public static List<EmailContentAddedEventResponse> getEmailContentAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EMAILCONTENTADDED_EVENT, transactionReceipt);
        ArrayList<EmailContentAddedEventResponse> responses = new ArrayList<EmailContentAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EmailContentAddedEventResponse typedResponse = new EmailContentAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EmailContentAddedEventResponse getEmailContentAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EMAILCONTENTADDED_EVENT, log);
        EmailContentAddedEventResponse typedResponse = new EmailContentAddedEventResponse();
        typedResponse.log = log;
        typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<EmailContentAddedEventResponse> emailContentAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEmailContentAddedEventFromLog(log));
    }

    public Flowable<EmailContentAddedEventResponse> emailContentAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EMAILCONTENTADDED_EVENT));
        return emailContentAddedEventFlowable(filter);
    }

    public static List<EmailRemovedFromBlacklistEventResponse> getEmailRemovedFromBlacklistEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EMAILREMOVEDFROMBLACKLIST_EVENT, transactionReceipt);
        ArrayList<EmailRemovedFromBlacklistEventResponse> responses = new ArrayList<EmailRemovedFromBlacklistEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EmailRemovedFromBlacklistEventResponse typedResponse = new EmailRemovedFromBlacklistEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EmailRemovedFromBlacklistEventResponse getEmailRemovedFromBlacklistEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(EMAILREMOVEDFROMBLACKLIST_EVENT, log);
        EmailRemovedFromBlacklistEventResponse typedResponse = new EmailRemovedFromBlacklistEventResponse();
        typedResponse.log = log;
        typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<EmailRemovedFromBlacklistEventResponse> emailRemovedFromBlacklistEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEmailRemovedFromBlacklistEventFromLog(log));
    }

    public Flowable<EmailRemovedFromBlacklistEventResponse> emailRemovedFromBlacklistEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EMAILREMOVEDFROMBLACKLIST_EVENT));
        return emailRemovedFromBlacklistEventFlowable(filter);
    }

    public static List<VoteCastedEventResponse> getVoteCastedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(VOTECASTED_EVENT, transactionReceipt);
        ArrayList<VoteCastedEventResponse> responses = new ArrayList<VoteCastedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VoteCastedEventResponse typedResponse = new VoteCastedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.voter = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.vote = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static VoteCastedEventResponse getVoteCastedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(VOTECASTED_EVENT, log);
        VoteCastedEventResponse typedResponse = new VoteCastedEventResponse();
        typedResponse.log = log;
        typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.voter = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.vote = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<VoteCastedEventResponse> voteCastedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getVoteCastedEventFromLog(log));
    }

    public Flowable<VoteCastedEventResponse> voteCastedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VOTECASTED_EVENT));
        return voteCastedEventFlowable(filter);
    }

    public static List<VoteInitiatedEventResponse> getVoteInitiatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(VOTEINITIATED_EVENT, transactionReceipt);
        ArrayList<VoteInitiatedEventResponse> responses = new ArrayList<VoteInitiatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VoteInitiatedEventResponse typedResponse = new VoteInitiatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.endTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static VoteInitiatedEventResponse getVoteInitiatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(VOTEINITIATED_EVENT, log);
        VoteInitiatedEventResponse typedResponse = new VoteInitiatedEventResponse();
        typedResponse.log = log;
        typedResponse.emailHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.endTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<VoteInitiatedEventResponse> voteInitiatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getVoteInitiatedEventFromLog(log));
    }

    public Flowable<VoteInitiatedEventResponse> voteInitiatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VOTEINITIATED_EVENT));
        return voteInitiatedEventFlowable(filter);
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
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Blacklist_sol_EmailBlacklistVoting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Blacklist_sol_EmailBlacklistVoting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class EmailBlacklistedEventResponse extends BaseEventResponse {
        public byte[] emailHash;

        public Boolean status;
    }

    public static class EmailContentAddedEventResponse extends BaseEventResponse {
        public byte[] emailHash;

        public String ipfsHash;
    }

    public static class EmailRemovedFromBlacklistEventResponse extends BaseEventResponse {
        public byte[] emailHash;
    }

    public static class VoteCastedEventResponse extends BaseEventResponse {
        public byte[] emailHash;

        public String voter;

        public Boolean vote;
    }

    public static class VoteInitiatedEventResponse extends BaseEventResponse {
        public byte[] emailHash;

        public BigInteger endTime;
    }
}
