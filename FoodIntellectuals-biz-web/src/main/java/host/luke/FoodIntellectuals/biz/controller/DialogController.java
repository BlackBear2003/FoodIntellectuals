package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.biz.entity.Dialog;
import host.luke.FoodIntellectuals.biz.service.DialogService;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dialog")
public class DialogController {
  @Autowired
  DialogService dialogService;

  @ApiOperation("上传日记")
  @PostMapping("/upload")
  ResponseDto<Void> upload(@RequestParam String title, @RequestParam String context, @RequestParam String createTime, @RequestParam MultipartFile file) {
    try {
      dialogService.saveDialog(title, context, createTime, file);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResponseDto.success("上传成功！");
  }

  @ApiOperation("列出日记")
  @PostMapping("/list")
  ResponseDto<List<Dialog>> listDialogs(@RequestParam Long userId, @RequestParam Integer page, @RequestParam Integer size) {

    return ResponseDto.success(dialogService.listDialog(userId, page, size));
  }
}
