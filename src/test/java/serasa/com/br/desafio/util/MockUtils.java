package serasa.com.br.desafio.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MockUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T readMockedJSON(final String fileName, final Class<T> valueType) {
        try (var resourceAsStream = MockUtils.class.getClassLoader()
                .getResourceAsStream("mocks" + FileSystems.getDefault().getSeparator() + fileName)) {
            return MockUtils.OBJECT_MAPPER.readValue(resourceAsStream, valueType);
        } catch (final IOException e) {
            throw new UncheckedIOException("IOException ao tentar ler o mocked json.", e);
        }
    }

    public static String readMockedJsonAsString(final String fileName) {
        try (var resourceAsStream = MockUtils.class.getClassLoader()
                .getResourceAsStream("mocks" + FileSystems.getDefault().getSeparator() + fileName)) {
            return MockUtils.OBJECT_MAPPER.writeValueAsString(resourceAsStream);
        } catch (final IOException e) {
            throw new UncheckedIOException("IOException ao tentar ler o mocked json.", e);
        }
    }
}