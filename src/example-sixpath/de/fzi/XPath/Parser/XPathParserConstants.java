/* Generated By:JavaCC: Do not edit this line. XPathParserConstants.java */
/*========================================================================*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License.
 * 
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for the specific language governing rights and
 * limitations under the License. 
 * 
 * The Original Code is all this file. 
 * 
 * The Initial Developer of the Original Code is
 * Aleksei Valikov, Forchungszentrum Informatik (valikov@fzi.de).
 * 
 * Portions created by Ingo Macherius, Gerald Huck <{macherius, huck}@gmd.de>
 * are Copyright (C) 1999 GMD.
 * All Rights Reserved. 
 * 
 * Contributor(s): none.
 *========================================================================*/

package de.fzi.XPath.Parser;

public interface XPathParserConstants {

  int EOF = 0;
  int S = 1;
  int SLASH = 2;
  int SLASHSLASH = 3;
  int UNION = 4;
  int PLUS = 5;
  int MINUS = 6;
  int EQ = 7;
  int NEQ = 8;
  int LT = 9;
  int LTE = 10;
  int GT = 11;
  int GTE = 12;
  int VARIABLE = 13;
  int Literal = 14;
  int Digit = 15;
  int Number = 16;
  int Letter = 17;
  int BaseChar = 18;
  int Ideographic = 19;
  int CombiningChar = 20;
  int UnicodeDigit = 21;
  int Extender = 22;
  int ID = 23;
  int OR = 24;
  int AND = 25;
  int MOD = 26;
  int DIV = 27;
  int KEY = 28;
  int NODE = 29;
  int TEXT = 30;
  int COMMENT = 31;
  int PI = 32;
  int AxisName = 33;
  int NCName = 34;

  int DEFAULT = 0;

  String[] tokenImage = {
    "<EOF>",
    "<S>",
    "\"/\"",
    "\"//\"",
    "\"|\"",
    "\"+\"",
    "\"-\"",
    "\"=\"",
    "\"!=\"",
    "\"<\"",
    "\"<=\"",
    "\">\"",
    "\">=\"",
    "\"$\"",
    "<Literal>",
    "<Digit>",
    "<Number>",
    "<Letter>",
    "<BaseChar>",
    "<Ideographic>",
    "<CombiningChar>",
    "<UnicodeDigit>",
    "<Extender>",
    "\"id\"",
    "\"or\"",
    "\"and\"",
    "\"mod\"",
    "\"div\"",
    "\"key\"",
    "\"node\"",
    "\"text\"",
    "\"comment\"",
    "\"processing-instruction\"",
    "<AxisName>",
    "<NCName>",
    "\":\"",
    "\"(\"",
    "\")\"",
    "\",\"",
    "\"@\"",
    "\".\"",
    "\"..\"",
    "\"[\"",
    "\"]\"",
    "\"*\"",
  };

}
