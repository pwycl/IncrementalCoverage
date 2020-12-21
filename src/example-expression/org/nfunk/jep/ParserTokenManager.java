/* Generated By:JJTree&JavaCC: Do not edit this line. ParserTokenManager.java */
package org.nfunk.jep;
import gov.nasa.jpf.jdart.Debug;
import test.expression.ExpressionConfig;

public class ParserTokenManager implements ParserConstants
{
	public  java.io.PrintStream debugStream = System.out;
	public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
	private final int jjStopStringLiteralDfa_1(int pos, long active0)
	{
		switch (pos)
		{
		case 0:
			if ((active0 & 0x100000000L) != 0L)
				return 1;
			if ((active0 & 0x200000000L) != 0L)
				return 13;
			return -1;
		default :
			return -1;
		}
	}
	private final int jjStartNfa_1(int pos, long active0)
	{
		return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
	}
	private final int jjStopAtPos(int pos, int kind)
	{
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		return pos + 1;
	}
	private final int jjStartNfaWithStates_1(int pos, int kind, int state)
	{
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		try { curChar = input_stream.readChar(); }
		catch(java.io.IOException e) { return pos + 1; }
		return jjMoveNfa_1(state, pos + 1);
	}
	private final int jjMoveStringLiteralDfa0_1()
	{
		switch(curChar)
		{
		case 33:
			jjmatchedKind = 35;
			return jjMoveStringLiteralDfa1_1(0x4000000L);
		case 37:
			return jjStopAtPos(0, 34);
		case 38:
			return jjMoveStringLiteralDfa1_1(0x8000000L);
		case 40:
			return jjStopAtPos(0, 40);
		case 41:
			return jjStopAtPos(0, 41);
		case 42:
			return jjStopAtPos(0, 31);
		case 43:
			return jjStopAtPos(0, 29);
		case 44:
			return jjStopAtPos(0, 20);
		case 45:
			return jjStopAtPos(0, 30);
		case 46:
			return jjStartNfaWithStates_1(0, 32, 1);
		case 47:
			return jjStartNfaWithStates_1(0, 33, 13);
		case 58:
			return jjStopAtPos(0, 42);
		case 59:
			return jjStopAtPos(0, 19);
		case 60:
			jjmatchedKind = 22;
			return jjMoveStringLiteralDfa1_1(0x1000000L);
		case 61:
			jjmatchedKind = 18;
			return jjMoveStringLiteralDfa1_1(0x800000L);
		case 62:
			jjmatchedKind = 21;
			return jjMoveStringLiteralDfa1_1(0x2000000L);
		case 91:
			return jjStopAtPos(0, 38);
		case 93:
			return jjStopAtPos(0, 39);
		case 94:
			jjmatchedKind = 36;
			return jjMoveStringLiteralDfa1_1(0x2000000000L);
		case 124:
			return jjMoveStringLiteralDfa1_1(0x10000000L);
		default :
			return jjMoveNfa_1(0, 0);
		}
	}
	private final int jjMoveStringLiteralDfa1_1(long active0)
	{
		try { curChar = input_stream.readChar(); }
		catch(java.io.IOException e) {
			jjStopStringLiteralDfa_1(0, active0);
			return 1;
		}
		switch(curChar)
		{
		case 38:
			if ((active0 & 0x8000000L) != 0L)
				return jjStopAtPos(1, 27);
			break;
		case 61:
			if ((active0 & 0x800000L) != 0L)
				return jjStopAtPos(1, 23);
			else if ((active0 & 0x1000000L) != 0L)
				return jjStopAtPos(1, 24);
			else if ((active0 & 0x2000000L) != 0L)
				return jjStopAtPos(1, 25);
			else if ((active0 & 0x4000000L) != 0L)
				return jjStopAtPos(1, 26);
			break;
		case 94:
			if ((active0 & 0x2000000000L) != 0L)
				return jjStopAtPos(1, 37);
			break;
		case 124:
			if ((active0 & 0x10000000L) != 0L)
				return jjStopAtPos(1, 28);
			break;
		default :
			break;
		}
		return jjStartNfa_1(0, active0);
	}
	private final void jjCheckNAdd(int state)
	{
		if (jjrounds[state] != jjround)
		{
			jjstateSet[jjnewStateCnt++] = state;
			jjrounds[state] = jjround;
		}
	}
	private final void jjAddStates(int start, int end)
	{
		do {
			jjstateSet[jjnewStateCnt++] = jjnextStates[start];
		} while (start++ != end);
	}
	private final void jjCheckNAddTwoStates(int state1, int state2)
	{
		jjCheckNAdd(state1);
		jjCheckNAdd(state2);
	}
	private final void jjCheckNAddStates(int start, int end)
	{
		do {
			jjCheckNAdd(jjnextStates[start]);
		} while (start++ != end);
	}
	private final void jjCheckNAddStates(int start)
	{
		jjCheckNAdd(jjnextStates[start]);
		jjCheckNAdd(jjnextStates[start + 1]);
	}
	static final long[] jjbitVec0 = {
		0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
	};
	static final long[] jjbitVec2 = {
		0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
	};
	static final long[] jjbitVec3 = {
		0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
	};
	static final long[] jjbitVec4 = {
		0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
	};
	static final long[] jjbitVec5 = {
		0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
	};
	static final long[] jjbitVec6 = {
		0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
	};
	static final long[] jjbitVec7 = {
		0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
	};
	static final long[] jjbitVec8 = {
		0x3fffffffffffL, 0x0L, 0x0L, 0x0L
	};
	private final int jjMoveNfa_1(int startState, int curPos)
	{
		int[] nextStates;
		int startsAt = 0;
		jjnewStateCnt = 36;
		int i = 1;
		jjstateSet[0] = startState;
		int j, kind = 0x7fffffff;
		for (;;)
		{
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64)
			{
				long l = 1L << curChar;
				MatchLoop: do
				{ 
					int ii=jjstateSet[--i];
					int ssss=curChar;
					switch(ii) // ori is jjstateSet[--i]
							{
							case 13:
								if (curChar == 42)
									jjCheckNAddTwoStates(19, 20);
								else if (curChar == 47)
									jjCheckNAddStates(0, 2);
								break;
							case 0:
								if ((0x3ff000000000000L & l) != 0L)
								{
									if (kind > 7)
										kind = 7;
									jjCheckNAddStates(3, 7);
								}
								else if (curChar == 47)
									jjAddStates(8, 9);
								else if (curChar == 36)
								{
									if (kind > 12)
										kind = 12;
									jjCheckNAdd(11);
								}
								else if (curChar == 34)
									jjCheckNAddStates(10, 12);
								else if (curChar == 46)
									jjCheckNAdd(1);
								break;
							case 1:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 9)
									kind = 9;
								jjCheckNAddTwoStates(1, 2);
								break;
							case 3:
								if ((0x280000000000L & l) != 0L)
									jjCheckNAdd(4);
								break;
							case 4:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 9)
									kind = 9;
								jjCheckNAdd(4);
								break;
							case 5:
								if (curChar == 34)
									jjCheckNAddStates(10, 12);
								break;
							case 6:
								if ((0xfffffffbffffdbffL & l) != 0L)
									jjCheckNAddStates(10, 12);
								break;
							case 8:
								if ((0x8400000000L & l) != 0L)
									jjCheckNAddStates(10, 12);
								break;
							case 9:
								if (curChar == 34 && kind > 11)
									kind = 11;
								break;
							case 10:
								if (curChar != 36)
									break;
								if (kind > 12)
									kind = 12;
								jjCheckNAdd(11);
								break;
							case 11:
								if ((0x3ff401000000000L & l) == 0L)
									break;
								if (kind > 12)
									kind = 12;
								jjCheckNAdd(11);
								break;
							case 12:
								if (curChar == 47)
									jjAddStates(8, 9);
								break;
							case 14:
								if ((0xffffffffffffdbffL & l) != 0L)
									jjCheckNAddStates(0, 2);
								break;
							case 15:
								if ((0x2400L & l) != 0L && kind > 5)
									kind = 5;
								break;
							case 16:
								if (curChar == 10 && kind > 5)
									kind = 5;
								break;
							case 17:
								if (curChar == 13)
									jjstateSet[jjnewStateCnt++] = 16;
								break;
							case 18:
								if (curChar == 42)
									jjCheckNAddTwoStates(19, 20);
								break;
							case 19:
								if ((0xfffffbffffffffffL & l) != 0L)
									jjCheckNAddTwoStates(19, 20);
								break;
							case 20:
								if (curChar == 42)
									jjAddStates(13, 14);
								break;
							case 21:
								if ((0xffff7fffffffffffL & l) != 0L)
									jjCheckNAddTwoStates(22, 20);
								break;
							case 22:
								if ((0xfffffbffffffffffL & l) != 0L)
									jjCheckNAddTwoStates(22, 20);
								break;
							case 23:
								if (curChar == 47 && kind > 6)
									kind = 6;
								break;
							case 24:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 7)
									kind = 7;
								jjCheckNAddStates(3, 7);
								break;
							case 25:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 7)
									kind = 7;
								jjCheckNAdd(25);
								break;
							case 26:
								if ((0x3ff000000000000L & l) != 0L)
									jjCheckNAddTwoStates(26, 27);
								break;
							case 27:
								if (curChar != 46)
									break;
								if (kind > 9)
									kind = 9;
								jjCheckNAddTwoStates(28, 29);
								break;
							case 28:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 9)
									kind = 9;
								jjCheckNAddTwoStates(28, 29);
								break;
							case 30:
								if ((0x280000000000L & l) != 0L)
									jjCheckNAdd(31);
								break;
							case 31:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 9)
									kind = 9;
								jjCheckNAdd(31);
								break;
							case 32:
								if ((0x3ff000000000000L & l) != 0L)
									jjCheckNAddTwoStates(32, 33);
								break;
							case 34:
								if ((0x280000000000L & l) != 0L)
									jjCheckNAdd(35);
								break;
							case 35:
								if ((0x3ff000000000000L & l) == 0L)
									break;
								if (kind > 9)
									kind = 9;
								jjCheckNAdd(35);
								break;
							default : break;
							}
				} while(i != startsAt);
			}
			else if (curChar < 128)
			{
				long l = 1L << (curChar & 077);
				MatchLoop: do
				{
					switch(jjstateSet[--i])
					{
					case 0:
					case 11:
						if ((0x7fffffe87fffffeL & l) == 0L)
							break;
						if (kind > 12)
							kind = 12;
						jjCheckNAdd(11);
						break;
					case 2:
						if ((0x2000000020L & l) != 0L)
							jjAddStates(15, 16);
						break;
					case 6:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAddStates(10, 12);
						break;
					case 7:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 8;
						break;
					case 8:
						if ((0x14404410000000L & l) != 0L)
							jjCheckNAddStates(10, 12);
						break;
					case 14:
						jjAddStates(0, 2);
						break;
					case 19:
						jjCheckNAddTwoStates(19, 20);
						break;
					case 21:
					case 22:
						jjCheckNAddTwoStates(22, 20);
						break;
					case 29:
						if ((0x2000000020L & l) != 0L)
							jjAddStates(17, 18);
						break;
					case 33:
						if ((0x2000000020L & l) != 0L)
							jjAddStates(19, 20);
						break;
					default : break;
					}
				} while(i != startsAt);
			}
			else
			{
				int hiByte = (int)(curChar >> 8);
				int i1 = hiByte >> 6;
				long l1 = 1L << (hiByte & 077);
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				MatchLoop: do
				{
					switch(jjstateSet[--i])
					{
					case 0:
					case 11:
						if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
							break;
						if (kind > 12)
							kind = 12;
						jjCheckNAdd(11);
						break;
					case 6:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjAddStates(10, 12);
						break;
					case 14:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjAddStates(0, 2);
						break;
					case 19:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjCheckNAddTwoStates(19, 20);
						break;
					case 21:
					case 22:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjCheckNAddTwoStates(22, 20);
						break;
					default : break;
					}
				} while(i != startsAt);
			}
			if (kind != 0x7fffffff)
			{
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 36 - (jjnewStateCnt = startsAt)))
				return curPos;
			try { curChar = input_stream.readChar(); }
			catch(java.io.IOException e) { return curPos; }
		}
	}
	private final int jjStopStringLiteralDfa_0(int pos, long active0)
	{
		switch (pos)
		{
		case 0:
			if ((active0 & 0x100000000L) != 0L)
				return 1;
			if ((active0 & 0x200000000L) != 0L)
				return 13;
			return -1;
		default :
			return -1;
		}
	}
	private final int jjStartNfa_0(int pos, long active0)
	{
		return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
	}
	private final int jjStartNfaWithStates_0(int pos, int kind, int state)
	{
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		try { curChar = input_stream.readChar(); }
		catch(java.io.IOException e) { return pos + 1; }
		return jjMoveNfa_0(state, pos + 1);
	}
	private final int jjMoveStringLiteralDfa0_0()
	{
		switch(curChar)
		{
		case 33:
			jjmatchedKind = 35;
			return jjMoveStringLiteralDfa1_0(0x4000000L);
		case 37:
			return jjStopAtPos(0, 34);
		case 38:
			return jjMoveStringLiteralDfa1_0(0x8000000L);
		case 40:
			return jjStopAtPos(0, 40);
		case 41:
			return jjStopAtPos(0, 41);
		case 42:
			return jjStopAtPos(0, 31);
		case 43:
			return jjStopAtPos(0, 29);
		case 44:
			return jjStopAtPos(0, 20);
		case 45:
			return jjStopAtPos(0, 30);
		case 46:
			return jjStartNfaWithStates_0(0, 32, 1);
		case 47:
			return jjStartNfaWithStates_0(0, 33, 13);
		case 58:
			return jjStopAtPos(0, 42);
		case 59:
			return jjStopAtPos(0, 19);
		case 60:
			jjmatchedKind = 22;
			return jjMoveStringLiteralDfa1_0(0x1000000L);
		case 61:
			jjmatchedKind = 18;
			return jjMoveStringLiteralDfa1_0(0x800000L);
		case 62:
			jjmatchedKind = 21;
			return jjMoveStringLiteralDfa1_0(0x2000000L);
		case 91:
			return jjStopAtPos(0, 38);
		case 93:
			return jjStopAtPos(0, 39);
		case 94:
			jjmatchedKind = 36;
			return jjMoveStringLiteralDfa1_0(0x2000000000L);
		case 124:
			return jjMoveStringLiteralDfa1_0(0x10000000L);
		default :
			return jjMoveNfa_0(0, 0);
		}
	}
	private final int jjMoveStringLiteralDfa1_0(long active0)
	{
		try { curChar = input_stream.readChar(); }
		catch(java.io.IOException e) {
			jjStopStringLiteralDfa_0(0, active0);
			return 1;
		}
		switch(curChar)
		{
		case 38:
			if ((active0 & 0x8000000L) != 0L)
				return jjStopAtPos(1, 27);
			break;
		case 61:
			if ((active0 & 0x800000L) != 0L)
				return jjStopAtPos(1, 23);
			else if ((active0 & 0x1000000L) != 0L)
				return jjStopAtPos(1, 24);
			else if ((active0 & 0x2000000L) != 0L)
				return jjStopAtPos(1, 25);
			else if ((active0 & 0x4000000L) != 0L)
				return jjStopAtPos(1, 26);
			break;
		case 94:
			if ((active0 & 0x2000000000L) != 0L)
				return jjStopAtPos(1, 37);
			break;
		case 124:
			if ((active0 & 0x10000000L) != 0L)
				return jjStopAtPos(1, 28);
			break;
		default :
			break;
		}
		return jjStartNfa_0(0, active0);
	}
	private final int jjMoveNfa_0(int startState, int curPos)
	{
		int[] nextStates;
		int startsAt = 0;
		jjnewStateCnt = 36;
		int i = 1;
		jjstateSet[0] = startState;
		int j, kind = 0x7fffffff;
		for (;;)
		{
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64)
			{
				long l = 1L << curChar;
				MatchLoop: do
				{
					switch(jjstateSet[--i])
					{
					case 13:
						if (curChar == 42)
							jjCheckNAddTwoStates(19, 20);
						else if (curChar == 47)
							jjCheckNAddStates(0, 2);
						break;
					case 0:
						if ((0x3ff000000000000L & l) != 0L)
						{
							if (kind > 7)
								kind = 7;
							jjCheckNAddStates(3, 7);
						}
						else if (curChar == 47)
							jjAddStates(8, 9);
						else if (curChar == 36)
						{
							if (kind > 15)
								kind = 15;
							jjCheckNAdd(11);
						}
						else if (curChar == 34)
							jjCheckNAddStates(10, 12);
						else if (curChar == 46)
							jjCheckNAdd(1);
						break;
					case 1:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 9)
							kind = 9;
						jjCheckNAddTwoStates(1, 2);
						break;
					case 3:
						if ((0x280000000000L & l) != 0L)
							jjCheckNAdd(4);
						break;
					case 4:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 9)
							kind = 9;
						jjCheckNAdd(4);
						break;
					case 5:
						if (curChar == 34)
							jjCheckNAddStates(10, 12);
						break;
					case 6:
						if ((0xfffffffbffffdbffL & l) != 0L)
							jjCheckNAddStates(10, 12);
						break;
					case 8:
						if ((0x8400000000L & l) != 0L)
							jjCheckNAddStates(10, 12);
						break;
					case 9:
						if (curChar == 34 && kind > 11)
							kind = 11;
						break;
					case 10:
						if (curChar != 36)
							break;
						if (kind > 15)
							kind = 15;
						jjCheckNAdd(11);
						break;
					case 11:
						if ((0x3ff001000000000L & l) == 0L)
							break;
						if (kind > 15)
							kind = 15;
						jjCheckNAdd(11);
						break;
					case 12:
						if (curChar == 47)
							jjAddStates(8, 9);
						break;
					case 14:
						if ((0xffffffffffffdbffL & l) != 0L)
							jjCheckNAddStates(0, 2);
						break;
					case 15:
						if ((0x2400L & l) != 0L && kind > 5)
							kind = 5;
						break;
					case 16:
						if (curChar == 10 && kind > 5)
							kind = 5;
						break;
					case 17:
						if (curChar == 13)
							jjstateSet[jjnewStateCnt++] = 16;
						break;
					case 18:
						if (curChar == 42)
							jjCheckNAddTwoStates(19, 20);
						break;
					case 19:
						if ((0xfffffbffffffffffL & l) != 0L)
							jjCheckNAddTwoStates(19, 20);
						break;
					case 20:
						if (curChar == 42)
							jjAddStates(13, 14);
						break;
					case 21:
						if ((0xffff7fffffffffffL & l) != 0L)
							jjCheckNAddTwoStates(22, 20);
						break;
					case 22:
						if ((0xfffffbffffffffffL & l) != 0L)
							jjCheckNAddTwoStates(22, 20);
						break;
					case 23:
						if (curChar == 47 && kind > 6)
							kind = 6;
						break;
					case 24:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 7)
							kind = 7;
						jjCheckNAddStates(3, 7);
						break;
					case 25:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 7)
							kind = 7;
						jjCheckNAdd(25);
						break;
					case 26:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddTwoStates(26, 27);
						break;
					case 27:
						if (curChar != 46)
							break;
						if (kind > 9)
							kind = 9;
						jjCheckNAddTwoStates(28, 29);
						break;
					case 28:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 9)
							kind = 9;
						jjCheckNAddTwoStates(28, 29);
						break;
					case 30:
						if ((0x280000000000L & l) != 0L)
							jjCheckNAdd(31);
						break;
					case 31:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 9)
							kind = 9;
						jjCheckNAdd(31);
						break;
					case 32:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddTwoStates(32, 33);
						break;
					case 34:
						if ((0x280000000000L & l) != 0L)
							jjCheckNAdd(35);
						break;
					case 35:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 9)
							kind = 9;
						jjCheckNAdd(35);
						break;
					default : break;
					}
				} while(i != startsAt);
			}
			else if (curChar < 128)
			{
				long l = 1L << (curChar & 077);
				MatchLoop: do
				{
					switch(jjstateSet[--i])
					{
					case 0:
					case 11:
						if ((0x7fffffe87fffffeL & l) == 0L)
							break;
						if (kind > 15)
							kind = 15;
						jjCheckNAdd(11);
						break;
					case 2:
						if ((0x2000000020L & l) != 0L)
							jjAddStates(15, 16);
						break;
					case 6:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAddStates(10, 12);
						break;
					case 7:
						if (curChar == 92)
							jjstateSet[jjnewStateCnt++] = 8;
						break;
					case 8:
						if ((0x14404410000000L & l) != 0L)
							jjCheckNAddStates(10, 12);
						break;
					case 14:
						jjAddStates(0, 2);
						break;
					case 19:
						jjCheckNAddTwoStates(19, 20);
						break;
					case 21:
					case 22:
						jjCheckNAddTwoStates(22, 20);
						break;
					case 29:
						if ((0x2000000020L & l) != 0L)
							jjAddStates(17, 18);
						break;
					case 33:
						if ((0x2000000020L & l) != 0L)
							jjAddStates(19, 20);
						break;
					default : break;
					}
				} while(i != startsAt);
			}
			else
			{
				int hiByte = (int)(curChar >> 8);
				int i1 = hiByte >> 6;
				long l1 = 1L << (hiByte & 077);
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				MatchLoop: do
				{
					switch(jjstateSet[--i])
					{
					case 0:
					case 11:
						if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
							break;
						if (kind > 15)
							kind = 15;
						jjCheckNAdd(11);
						break;
					case 6:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjAddStates(10, 12);
						break;
					case 14:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjAddStates(0, 2);
						break;
					case 19:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjCheckNAddTwoStates(19, 20);
						break;
					case 21:
					case 22:
						if (jjCanMove_0(hiByte, i1, i2, l1, l2))
							jjCheckNAddTwoStates(22, 20);
						break;
					default : break;
					}
				} while(i != startsAt);
			}
			if (kind != 0x7fffffff)
			{
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 36 - (jjnewStateCnt = startsAt)))
				return curPos;
			try { curChar = input_stream.readChar(); }
			catch(java.io.IOException e) { return curPos; }
		}
	}
	static final int[] jjnextStates = {
		14, 15, 17, 25, 26, 27, 32, 33, 13, 18, 6, 7, 9, 21, 23, 3, 
		4, 30, 31, 34, 35, 
	};
	private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
	{
		switch(hiByte)
		{
		case 0:
			return ((jjbitVec2[i2] & l2) != 0L);
		default : 
			if ((jjbitVec0[i1] & l1) != 0L)
				return true;
			return false;
		}
	}
	private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
	{
		switch(hiByte)
		{
		case 0:
			return ((jjbitVec4[i2] & l2) != 0L);
		case 48:
			return ((jjbitVec5[i2] & l2) != 0L);
		case 49:
			return ((jjbitVec6[i2] & l2) != 0L);
		case 51:
			return ((jjbitVec7[i2] & l2) != 0L);
		case 61:
			return ((jjbitVec8[i2] & l2) != 0L);
		default : 
			if ((jjbitVec3[i1] & l1) != 0L)
				return true;
			return false;
		}
	}
	public static final String[] jjstrLiteralImages = {
		"", null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "\75", "\73", "\54", "\76", "\74", "\75\75", "\74\75", 
		"\76\75", "\41\75", "\46\46", "\174\174", "\53", "\55", "\52", "\56", "\57", "\45", 
		"\41", "\136", "\136\136", "\133", "\135", "\50", "\51", "\72", };
	public static final String[] lexStateNames = {
		"NO_DOT_IN_IDENTIFIERS", 
		"DEFAULT", 
	};
	public static final int[] jjnewLexState = {
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
	};
	static final long[] jjtoToken = {
		0x7fffffc9a81L, 
	};
	static final long[] jjtoSkip = {
		0x7eL, 
	};
	public JavaCharStream input_stream;
	private final int[] jjrounds = new int[36];
	private final int[] jjstateSet = new int[72];
	protected char curChar;
	public ParserTokenManager(JavaCharStream stream)
	{
		if (JavaCharStream.staticFlag)
			throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
		input_stream = stream;
	}
	public ParserTokenManager(JavaCharStream stream, int lexState)
	{
		this(stream);
		SwitchTo(lexState);
	}
	public void ReInit(JavaCharStream stream)
	{
		jjmatchedPos = jjnewStateCnt = 0;
		curLexState = defaultLexState;
		input_stream = stream;
		ReInitRounds();
	}
	private final void ReInitRounds()
	{
		int i;
		jjround = 0x80000001;
		for (i = 36; i-- > 0;)
			jjrounds[i] = 0x80000000;
	}
	public void ReInit(JavaCharStream stream, int lexState)
	{
		ReInit(stream);
		SwitchTo(lexState);
	}
	public void SwitchTo(int lexState)
	{
		if (lexState >= 2 || lexState < 0)
			throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
		else
			curLexState = lexState;
	}

	protected Token jjFillToken()
	{
		Token t = Token.newToken(jjmatchedKind);
		t.kind = jjmatchedKind;
		String im = jjstrLiteralImages[jjmatchedKind];
		t.image = (im == null) ? input_stream.GetImage() : im;
		t.beginLine = input_stream.getBeginLine();
		t.beginColumn = input_stream.getBeginColumn();
		t.endLine = input_stream.getEndLine();
		t.endColumn = input_stream.getEndColumn();
		return t;
	}

	int curLexState = 1;
	int defaultLexState = 1;
	int jjnewStateCnt;
	int jjround;
	int jjmatchedPos;
	int jjmatchedKind;


	//for token symbolic
	public static int token_index = 0;
	public static Token oldtoken=null;
	public boolean isSameToken(Token t1,Token t2){
//		System.out.println(t2.beginLine+" "+t2.beginColumn+" "+t2.endLine+" "+t2.endColumn);
		if(t1==null)
			return false;
		return (t1.kind==t2.kind && t1.image.equals(t2.image)&& t1.beginLine==t2.beginLine && t1.beginColumn==t2.beginColumn && t1.endLine==t2.endLine && t1.endColumn==t2.endColumn);
	}
	public Token getNextToken() 
	{
		int kind;
		Token specialToken = null;
		Token matchedToken;
		int curPos = 0;

		EOFLoop :
			for (;;)
			{   
				try   
				{     
					curChar = input_stream.BeginToken();
				}     
				catch(java.io.IOException e)
				{
					jjmatchedKind = 0;
					matchedToken = jjFillToken();
					//    return matchedToken;
					if(matchedToken.kind==0) // unsymb EOF
						return matchedToken;
					Debug.GenTokenStringByConcolic(""+matchedToken.kind,matchedToken.image);
					if (Debug.isGenTokenStringByConcolic())
					{
						Debug.SystemExit();
					}
					if (Debug.isTokenSymb())
						Debug.cleanPC();

//					if(ExpressionConfig.SYMB_FLAG==false || ExpressionConfig.TOKEN_SYMB==false)
					if (!Debug.isTokenSymb())
					{
						System.out.println("getNextToken image: "+matchedToken.image);
						System.out.println("getNextToken kind: "+ParserConstants.tokenImage[matchedToken.kind]);
						System.out.println("-----------token_index: "+token_index);
						return matchedToken;
					}
					int c;
					if (isSameToken(oldtoken, matchedToken)) {
						//					if (oldtoken == matchedToken.kind){
						c = Debug.makeConcolicInteger("sym_token_" + (token_index - 1),
								"" + (int) matchedToken.kind , "1");
					} else {
						//			System.out.println("start to create: " + pos + ":" + token + ":" +token_index);
						c = Debug.makeConcolicInteger("sym_token_" + token_index, ""
								+ (int) matchedToken.kind , "1");
						token_index++;
						oldtoken=matchedToken;
					}
					matchedToken.kind=c;
					return matchedToken;
				}
				switch(curLexState)
				{
				case 0:
					try { input_stream.backup(0);
					while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
						curChar = input_stream.BeginToken();
					}
					catch (java.io.IOException e1) { continue EOFLoop; }
					jjmatchedKind = 0x7fffffff;
					jjmatchedPos = 0;
					curPos = jjMoveStringLiteralDfa0_0();
					break;
				case 1:
					try { input_stream.backup(0);
					while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
						curChar = input_stream.BeginToken();
					}
					catch (java.io.IOException e1) { continue EOFLoop; }
					jjmatchedKind = 0x7fffffff;
					jjmatchedPos = 0;
					curPos = jjMoveStringLiteralDfa0_1();
					break;
				}
				if (jjmatchedKind != 0x7fffffff)
				{
					if (jjmatchedPos + 1 < curPos)
						input_stream.backup(curPos - jjmatchedPos - 1);
					if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
					{
						matchedToken = jjFillToken();
						if (jjnewLexState[jjmatchedKind] != -1)
							curLexState = jjnewLexState[jjmatchedKind];
//					    return matchedToken;
						if(matchedToken.kind==0) // unsymb EOF
							return matchedToken;
						Debug.GenTokenStringByConcolic(""+matchedToken.kind,matchedToken.image);
						if (Debug.isGenTokenStringByConcolic())
						{
							Debug.SystemExit();
						}
						if (Debug.isTokenSymb())
							Debug.cleanPC();

//						if(ExpressionConfig.SYMB_FLAG==false || ExpressionConfig.TOKEN_SYMB==false)
						if (!Debug.isTokenSymb())
						{
							System.out.println("getNextToken image: "+matchedToken.image);
							System.out.println("getNextToken kind: "+ParserConstants.tokenImage[matchedToken.kind]);
							System.out.println("-----------token_index: "+token_index);
							return matchedToken;
						}
						int c;
						if (isSameToken(oldtoken, matchedToken)) {
							//					if (oldtoken == matchedToken.kind){
							c = Debug.makeConcolicInteger("sym_token_" + (token_index - 1),
									"" + (int) matchedToken.kind , "1");
						} else {
							//			System.out.println("start to create: " + pos + ":" + token + ":" +token_index);
							c = Debug.makeConcolicInteger("sym_token_" + token_index,
									"" + (int) matchedToken.kind , "1");
							token_index++;
							oldtoken=matchedToken;
						}
						matchedToken.kind=c;
						return matchedToken;
					}
					else
					{
						if (jjnewLexState[jjmatchedKind] != -1)
							curLexState = jjnewLexState[jjmatchedKind];
						continue EOFLoop;
					}
				}
				int error_line = input_stream.getEndLine();
				int error_column = input_stream.getEndColumn();
				String error_after = null;
				boolean EOFSeen = false;
				try { input_stream.readChar(); input_stream.backup(1); }
				catch (java.io.IOException e1) {
					EOFSeen = true;
					error_after = curPos <= 1 ? "" : input_stream.GetImage();
					if (curChar == '\n' || curChar == '\r') {
						error_line++;
						error_column = 0;
					}
					else
						error_column++;
				}
				if (!EOFSeen) {
					input_stream.backup(1);
					error_after = curPos <= 1 ? "" : input_stream.GetImage();
				}
				throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
			}
	}

}
