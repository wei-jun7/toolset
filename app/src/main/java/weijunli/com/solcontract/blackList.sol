// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract EmailBlacklistVoting {
    address public owner;
    mapping(bytes32 => bool) private blacklist;
    mapping(bytes32 => mapping(address => bool)) public hasVoted;
    mapping(bytes32 => uint256) private positiveVotes;
    mapping(bytes32 => uint256) private negativeVotes;
    mapping(bytes32 => string) private emailContentHashes;
    string public latestBlacklistCid;
    uint256 public constant VOTES_REQUIRED_FOR_REMOVAL = 3;
    uint256 public constant VOTING_DURATION = 3 days;
    mapping(bytes32 => uint256) public voteEndTime;

    constructor() {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Not authorized");
        _;
    }
    function updateBlacklistCid(string memory _newCid) public {
        latestBlacklistCid = _newCid;
    }

    function setBlacklistStatus(string memory email, bool status, string memory ipfsHash) public onlyOwner {
        bytes32 emailHash = keccak256(abi.encodePacked(email));
        blacklist[emailHash] = status;
        emailContentHashes[emailHash] = ipfsHash;
    }


    function getEmailContentHash(string memory email) public view returns (string memory) {
        bytes32 emailHash = keccak256(abi.encodePacked(email));
        return emailContentHashes[emailHash];
    }


    function isBlacklisted(string memory email) public view returns (bool) {
        bytes32 emailHash = keccak256(abi.encodePacked(email));
        return blacklist[emailHash];
    }


    function initiateVote(string memory email) public {
        bytes32 emailHash = keccak256(abi.encodePacked(email));
        require(blacklist[emailHash], "Email not in blacklist");
        voteEndTime[emailHash] = block.timestamp + VOTING_DURATION;
    }


    function castVote(string memory email, bool voteToRemove) public {
        bytes32 emailHash = keccak256(abi.encodePacked(email));
        require(block.timestamp <= voteEndTime[emailHash], "Voting period over");
        require(!hasVoted[emailHash][msg.sender], "Already voted");

        if (voteToRemove) {
            positiveVotes[emailHash]++;
            if(positiveVotes[emailHash] >= VOTES_REQUIRED_FOR_REMOVAL && positiveVotes[emailHash] > (positiveVotes[emailHash] + negativeVotes[emailHash]) / 2) {
                blacklist[emailHash] = false;
                emailContentHashes[emailHash] = "";
            }
        } else {
            negativeVotes[emailHash]++;
        }

        hasVoted[emailHash][msg.sender] = true;
    }

    function votesNeeded(string memory email) public view returns (uint256) {
        bytes32 emailHash = keccak256(abi.encodePacked(email));
        uint256 currentPositiveVotes = positiveVotes[emailHash];
        if(currentPositiveVotes >= VOTES_REQUIRED_FOR_REMOVAL && currentPositiveVotes > (positiveVotes[emailHash] + negativeVotes[emailHash]) / 2) {
            return 0;
        }
        return VOTES_REQUIRED_FOR_REMOVAL - currentPositiveVotes;
    }
}