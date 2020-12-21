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
 * Contributor(s): none.
 *========================================================================*/

package de.fzi.XPath;

/**
 * A Class class.
 * <P>
 * @author Aleksei Valikov
 */
public class Literal extends Expr
{

  String value;
  /**
   * Constructor
   */
  public Literal(String thevalue)
  {
    value = thevalue;
  }

  public String getValue()
  {
    return value;
  }

  public String toString()
  {
    return "'" + value + "'";
  }
}

 