package seu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class IntegratedNFA {

    /* The transition table of the NFA */
    public Vector<Vector<HashSet<Integer>>> transitionTable = new Vector<>();
    /* State to start always 0 */
    public final static int start = 0;
    /* State to accept with action */
    public HashMap<Integer, String> accept = new HashMap<>();

    public IntegratedNFA() {
        Vector<HashSet<Integer>> startStateRow = NFAUtil.initStateRow();
        transitionTable.add(startStateRow);
    }

    public void integrate(NFA nfa, String action) {
        NFAUtil.addTransition(transitionTable.firstElement(), NFAUtil.EPSILON, transitionTable.size());
        transitionTable.addAll(nfa.increasedStateNumber(transitionTable.size()));
        accept.put(transitionTable.size() - 1, action);
    }
}
