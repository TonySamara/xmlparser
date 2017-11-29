package solution.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import solution.tools.FileManager;
import solution.tools.XMLParser;

import java.io.File;
import java.util.List;

@Controller
public class IndexPageController {

    @RequestMapping({"/index","/"})
    public String printPage(){
        return "index";
    }

    @RequestMapping("/calculate")
    public String calculateValuesForTag(
            @RequestParam("directory") String directory,
            @RequestParam("tag") String tag,
            @RequestParam("attribute") String attribute,
            Model model){
        List<File> xmlFiles = FileManager.getAllXMLFilesInFolder(directory);
        System.out.println(xmlFiles);
        List<String> valuesList = XMLParser.getValuesByTagName(xmlFiles, tag, attribute);
        System.out.println(valuesList.size());
        model.addAttribute("directory" ,directory);
        model.addAttribute("tag", tag);
        model.addAttribute("attribute", attribute);
        model.addAttribute("valuesList", valuesList);
        return "index";
    }
}
