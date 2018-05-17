package seu;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class NFATest {

    @Test
    @Ignore
    public void constructor() throws Exception {
        System.out.println(new NFA().debugMessage());
        System.out.println(new NFA('a').debugMessage());
        System.out.println(new NFA('a', 'z').debugMessage());
    }

    @Test
    @Ignore
    public void concat() throws Exception {
        NFA nfa1 = new NFA('0', '3');
        NFA nfa2 = new NFA('3', '5');
        NFA nfa3 = NFAUtil.concat(nfa1, nfa2);
        System.out.println(nfa3.debugMessage());
        nfa3 = NFAUtil.concat(nfa3, nfa3);
        System.out.println(nfa3.debugMessage());
    }

    @Test
    @Ignore
    public void or() throws Exception {
        NFA nfa1 = new NFA('0', '3');
        NFA nfa2 = new NFA('3', '5');
        NFA nfa3 = NFAUtil.or(nfa1, nfa2);
        System.out.println(nfa3.debugMessage());
        nfa3 = NFAUtil.or(nfa3, nfa3);
        System.out.println(nfa3.debugMessage());
    }

    @Test
    @Ignore
    public void star() throws Exception {
        NFA nfa1 = new NFA('0', '3');
        NFA nfa2 = new NFA('3', '5');
        System.out.println(NFAUtil.star(nfa1).debugMessage());
        System.out.println(NFAUtil.star(nfa2).debugMessage());
        System.out.println(NFAUtil.star(new NFA()).debugMessage());
    }

    @Test
    @Ignore
    public void plus() throws Exception {
        NFA nfa1 = new NFA('0', '3');
        NFA nfa2 = new NFA('3', '5');
        System.out.println(NFAUtil.plus(nfa1).debugMessage());
        System.out.println(NFAUtil.plus(nfa2).debugMessage());
        System.out.println(NFAUtil.plus(new NFA()).debugMessage());
    }

    @Test
    @Ignore
    public void dot() {
        NFA nfa1 = NFAUtil.dot();
        System.out.println(nfa1.debugMessage());
    }

    @Test
    @Ignore
    public void square() {
        Vector<Character> characters = new Vector<>();
        characters.add('a');
        characters.add('1');
        characters.add((char) 0);
        characters.add(NFAUtil.EPSILON);
        NFA nfa1 = NFAUtil.square(characters);
        System.out.println(nfa1.debugMessage());
    }

    @Test
    @Ignore
    public void not() {
        Vector<Character> characters = new Vector<>();
        characters.add('a');
        characters.add('1');
        characters.add((char) 0);
        characters.add(NFAUtil.EPSILON);
        NFA nfa1 = NFAUtil.not(characters);
        System.out.println(nfa1.debugMessage());
    }

    @Test
    @Ignore
    public void repeat() throws Exception {
        NFA nfa1 = new NFA('0', '3');
        NFA nfa2 = NFAUtil.repeat(nfa1, 3, 5);
        System.out.println(nfa2.debugMessage());
    }

    @Test
    @Ignore
    public void question() throws Exception {
        NFA nfa1 = new NFA('0', '3');
        NFA nfa2 = new NFA('3', '5');
        System.out.println(NFAUtil.question(nfa1).debugMessage());
        System.out.println(NFAUtil.question(nfa2).debugMessage());
        System.out.println(NFAUtil.question(new NFA()).debugMessage());
    }

    @Test
    @Ignore
    public void regExpToNFA() throws Exception {
        Vector<String> regExps = new Vector<>();
        regExps.add("\"if\"");
        regExps.add("[a]");
        NFA nfa1 = NFAUtil.regExpToNFA(regExps.get(1));
        System.out.println(nfa1.debugMessage());
    }
}