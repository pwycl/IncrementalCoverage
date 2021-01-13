#!/bin/bash

export JAVA_HOME=/usr/local/jdk1.8
export JDK_HOME=/usr/local/jdk1.8

#ant coverage-example-javaparser
#ant coverage-example-jsqlparser
#ant coverage-example-MarkdownPapers
#ant coverage-example-sixpath
#ant coverage-example-fastjson-dev
#ant coverage-example-mXparser

ant instrument

#className="test.JavaparserDriver"
#saveInputFile="src/example-javaparser/TestJavaparserParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javaparser/TestJavaparserParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javaparser/TestJavaparserParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javaparser/TestJavaparserParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.FastjsonDriver"
#saveInputFile="src/example-fastjson-dev/TestFastJSONDevParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-fastjson-dev/TestFastJSONDevParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-fastjson-dev/TestFastJSONDevParser-TokenSymb-genTokenString-TokenLengthBound5-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-fastjson-dev/TestFastJSONDevParser-TokenSymb-genTokenString-TokenLengthBound5-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.sixpath.SixpathDriver"
#saveInputFile="src/example-sixpath/TestSixpathParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-sixpath/TestSixpathParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-sixpath/TestSixpathParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-sixpath/TestSixpathParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.awkparser.awkDriver"
#saveInputFile="src/example-awkparser/TestAwkParserDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-awkparser/TestAwkParserDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-awkparser/TestAwkParserDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-awkparser/TestAwkParserDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.CurtaDriver"
#saveInputFile="src/example-curta/TestCurtaParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-curta/TestCurtaParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-curta/TestCurtaParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-curta/TestCurtaParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#
#className="test.MarkdownPapersDriver"
#saveInputFile="src/example-MarkdownPapers/TestMDPParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-MarkdownPapers/TestMDPParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-MarkdownPapers/TestMDPParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-MarkdownPapers/TestMDPParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#
#className="test.firstorder.FirstOrderDriver"
#saveInputFile="src/example-firstorderparser/TestFirstOrderParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-firstorderparser/TestFirstOrderParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-firstorderparser/TestFirstOrderParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-firstorderparser/TestFirstOrderParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#
#className="test.HtmlgramDriver"
#saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.FastjsonDriver"
#saveInputFile="src/example-fastjson-dev/grammar-fuzzer.saveinput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.MarkdownPapersDriver"
#saveInputFile="src/example-MarkdownPapers/grammar-fuzzer.saveinput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.J2LatexDriver"
#saveInputFile="src/example-j2latex/TestJ2LatexDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-j2latex/TestJ2LatexDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-j2latex/TestJ2LatexDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-j2latex/TestJ2LatexDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.JavaccClojureDriver"
#saveInputFile="src/example-javacc-clojure/TestJavaccClojureDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javacc-clojure/TestJavaccClojureDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javacc-clojure/TestJavaccClojureDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javacc-clojure/TestJavaccClojureDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#
#className="test.javaccgrammarDriver"
#saveInputFile="src/example-javaccgrammar/TestJavaccGrammarDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javaccgrammar/TestJavaccGrammarDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javaccgrammar/TestJavaccGrammarDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-javaccgrammar/TestJavaccGrammarDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#
#className="org.mwnorman.json.test.jsonParserMwnormanDriver"
#saveInputFile="src/example-jsonparser-mwnorman/TestJsonParserMwnormanDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-jsonparser-mwnorman/TestJsonParserMwnormanDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-jsonparser-mwnorman/TestJsonParserMwnormanDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-jsonparser-mwnorman/TestJsonParserMwnormanDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.mapl.maplDriver"
#saveInputFile="src/example-mapl/TestMaplDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-mapl/TestMaplDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-mapl/TestMaplDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-mapl/TestMaplDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.oajavaparserDriver"
#saveInputFile="src/example-oajavaparser/TestOaJavaParserDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-oajavaparser/TestOaJavaParserDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-oajavaparser/TestOaJavaParserDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-oajavaparser/TestOaJavaParserDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

className="test.sqlparserDriver"
saveInputFile="src/example-sqlparser/TestSqlParserDriver-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-sqlparser/TestSqlParserDriver-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-sqlparser/TestSqlParserDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-sqlparser/TestSqlParserDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

#className="test.urijavaccDriver"
#saveInputFile="src/example-urijavacc/TestUriJavaccDriver-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-urijavacc/TestUriJavaccDriver-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-urijavacc/TestUriJavaccDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
#saveInputFile="src/example-urijavacc/TestUriJavaccDriver-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
#ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

