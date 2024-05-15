package per.khalilov.generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import per.khalilov.model.MagicItemData;
import per.khalilov.model.MagicItems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MagicItemTestDataParser {

    public static List<MagicItemData> parseMagicItemData(String fileName) throws JsonProcessingException {
        File file = new File(fileName);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = null;
        try {
            xml = inputStreamToString(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MagicItems value = xmlMapper.readValue(xml, MagicItems.class);

        return value.getMagicItems();
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
