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

className="test.CurtaDriver"
saveInputFile="src/example-curta/TestCurtaParser-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-curta/TestCurtaParser-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-curta/TestCurtaParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-curta/TestCurtaParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

className="test.MarkdownPapersDriver"
saveInputFile="src/example-MarkdownPapers/TestMDPParser-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-MarkdownPapers/TestMDPParser-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-MarkdownPapers/TestMDPParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-MarkdownPapers/TestMDPParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

className="test.firstorder.FirstOrderDriver"
saveInputFile="src/example-firstorderparser/TestFirstOrderParser-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-firstorderparser/TestFirstOrderParser-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-firstorderparser/TestFirstOrderParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-firstorderparser/TestFirstOrderParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}

className="test.HtmlgramDriver"
saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-bfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
saveInputFile="src/example-htmlgramparser/TestHtmlGramParser-TokenSymb-genTokenString-TokenLengthBound3-stage3-dfs.saveInput"
ant GenCoverage -DclassToRun=${className}  -DSaveInputFile=${saveInputFile}
