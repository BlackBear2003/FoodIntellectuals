package host.luke.FoodIntellectuals.biz.service;

import host.luke.FoodIntellectuals.biz.entity.Dialog;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DialogService {
  void saveDialog(String title, String context, String createTime, MultipartFile file,Long userId) throws IOException;
  List<Dialog> listDialog(Long userId,Integer page,Integer size);
}
