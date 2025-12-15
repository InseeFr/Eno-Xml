package fr.insee.eno.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;
import org.xmlunit.input.CommentLessSource;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLDiff {

    final Logger logger = LoggerFactory.getLogger(XMLDiff.class);

    public Diff getDiff(File input, File expected) {
        logger.debug("Diff {} with {}", input.getAbsolutePath(), expected.getAbsolutePath());
        CommentLessSource inputStream;
        CommentLessSource expectedStream;

        inputStream = new CommentLessSource(new StreamSource(input));
        expectedStream = new CommentLessSource(new StreamSource(expected));

        return DiffBuilder
                .compare(expectedStream)
                .withAttributeFilter(attr -> !attr.getName().equals("enoCoreVersion"))
                .withTest(inputStream)
                .ignoreWhitespace()
                .normalizeWhitespace()
                .checkForIdentical()
                .build();
    }

}
