package com.example.quizdapp.data;

import com.example.quizdapp.data.Question;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
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

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Quiz_sol_Quiz extends Contract {
    public static final String BINARY = "608060405261000c610011565b61031b565b6040805160a081018252602291810182815260009282919061090a606084013981526001602091820181905283549081018455600093845292208151919260020201908190610060908261025c565b50602091909101516001909101805460ff19169115159190911790556040805160a0810182526027918101828152600092829190610951606084013981526000602091820181905283546001810185559381522081519192600202019081906100c9908261025c565b50602091909101516001909101805460ff19169115159190911790556040805160a0810182526027918101828152600092829190610978606084013981526001602091820181905283549081018455600093845292208151919260020201908190610134908261025c565b50602091909101516001909101805460ff19169115159190911790556040805160a081018252602591810182815260009282919061092c60608401398152600160209182018190528354908101845560009384529220815191926002020190819061019f908261025c565b50602091909101516001909101805460ff1916911515919091179055565b634e487b7160e01b600052604160045260246000fd5b600181811c908216806101e757607f821691505b60208210810361020757634e487b7160e01b600052602260045260246000fd5b50919050565b601f82111561025757600081815260208120601f850160051c810160208610156102345750805b601f850160051c820191505b8181101561025357828155600101610240565b5050505b505050565b81516001600160401b03811115610275576102756101bd565b6102898161028384546101d3565b8461020d565b602080601f8311600181146102be57600084156102a65750858301515b600019600386901b1c1916600185901b178555610253565b600085815260208120601f198616915b828110156102ed578886015182559484019460019091019084016102ce565b508582101561030b5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b6105e08061032a6000396000f3fe6080604052600436106100295760003560e01c80632e7dc4b71461002e57806397221ab714610038575b600080fd5b610036610063565b005b34801561004457600080fd5b5061004d61020f565b60405161005a919061030f565b60405180910390f35b6040805160a08101825260229181018281526000928291906105166060840139815260016020918201819052835490810184556000938452922081519192600202019081906100b29082610455565b50602091909101516001909101805460ff19169115159190911790556040805160a081018252602791810182815260009282919061055d6060840139815260006020918201819052835460018101855593815220815191926002020190819061011b9082610455565b50602091909101516001909101805460ff19169115159190911790556040805160a08101825260279181018281526000928291906105846060840139815260016020918201819052835490810184556000938452922081519192600202019081906101869082610455565b50602091909101516001909101805460ff19169115159190911790556040805160a08101825260259181018281526000928291906105386060840139815260016020918201819052835490810184556000938452922081519192600202019081906101f19082610455565b50602091909101516001909101805460ff1916911515919091179055565b60606000805480602002602001604051908101604052809291908181526020016000905b828210156103065783829060005260206000209060020201604051806040016040529081600082018054610266906103cc565b80601f0160208091040260200160405190810160405280929190818152602001828054610292906103cc565b80156102df5780601f106102b4576101008083540402835291602001916102df565b820191906000526020600020905b8154815290600101906020018083116102c257829003601f168201915b505050918352505060019182015460ff161515602091820152918352929092019101610233565b50505050905090565b60006020808301818452808551808352604092508286019150828160051b8701018488016000805b848110156103a757603f198a8503018652825180518886528051808a880152845b81811015610374578281018c0151888201606001528b01610358565b508681016060908101869052928b015115158b880152978a0197601f01601f191690950101935091870191600101610337565b50919998505050505050505050565b634e487b7160e01b600052604160045260246000fd5b600181811c908216806103e057607f821691505b60208210810361040057634e487b7160e01b600052602260045260246000fd5b50919050565b601f82111561045057600081815260208120601f850160051c8101602086101561042d5750805b601f850160051c820191505b8181101561044c57828155600101610439565b5050505b505050565b815167ffffffffffffffff81111561046f5761046f6103b6565b6104838161047d84546103cc565b84610406565b602080601f8311600181146104b857600084156104a05750858301515b600019600386901b1c1916600185901b17855561044c565b600085815260208120601f198616915b828110156104e7578886015182559484019460019091019084016104c8565b50858210156105055787850151600019600388901b60f8161c191681555b5050505050600190811b0190555056fe47656e2e2042616a7761206973207468652043454f206f662050616b697374616e3f536d61727420636f6e74726163742072656d6f76657320696e7465726d656469617269657346697265626173652077617320616371756972656420627920676f6f676c6520696e2032303133426974636f696e20697320616e206170706c69636174696f6e206f6620426c6f636b636861696ea2646970667358221220eac1c710982f8bf24dba5da74f863eb8e7d8cf27142a86540ddb2a22256e858c64736f6c6343000810003347656e2e2042616a7761206973207468652043454f206f662050616b697374616e3f536d61727420636f6e74726163742072656d6f76657320696e7465726d656469617269657346697265626173652077617320616371756972656420627920676f6f676c6520696e2032303133426974636f696e20697320616e206170706c69636174696f6e206f6620426c6f636b636861696e";

    public static final String FUNC_ADDQUESTIONS = "addQuestions";

    public static final String FUNC_GETQUESTIONS = "getQuestions";

    @Deprecated
    protected Quiz_sol_Quiz(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Quiz_sol_Quiz(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Quiz_sol_Quiz(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Quiz_sol_Quiz(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addQuestions() {
        final Function function = new Function(
                FUNC_ADDQUESTIONS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getQuestions() {
        final Function function = new Function(FUNC_GETQUESTIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Question>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    @Deprecated
    public static Quiz_sol_Quiz load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Quiz_sol_Quiz(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Quiz_sol_Quiz load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Quiz_sol_Quiz(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Quiz_sol_Quiz load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Quiz_sol_Quiz(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Quiz_sol_Quiz load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Quiz_sol_Quiz(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Quiz_sol_Quiz> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Quiz_sol_Quiz.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Quiz_sol_Quiz> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Quiz_sol_Quiz.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Quiz_sol_Quiz> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Quiz_sol_Quiz.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Quiz_sol_Quiz> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Quiz_sol_Quiz.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
