package host.luke.FoodIntellectuals.biz.service.impl;

import host.luke.FoodIntellectuals.biz.entity.Dialog;
import host.luke.FoodIntellectuals.biz.repository.DialogRepository;
import host.luke.FoodIntellectuals.biz.service.DialogService;
import host.luke.FoodIntellectuals.oss.service.OssService;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DialogServiceImpl implements DialogService {

  @Autowired
  OssService ossService;
  @Autowired
  DialogRepository dialogRepository;

  @Override
  public void saveDialog(String title, String context, String createTime, MultipartFile file,
      Long userId) throws IOException {
    String url = null;
    if (file != null) {
      byte[] fileBytes = file.getBytes();
      String base64String = Base64.getEncoder().encodeToString(fileBytes);
      url = ossService.uploadImg(base64String);
    }

    Dialog dialog = new Dialog();
    dialog.setImgUrl(url);
    dialog.setContext(context);
    dialog.setUserId(userId);
    dialog.setTitle(title);
    dialog.setCreateTime(createTime);
    dialogRepository.save(dialog);
  }

  @Override
  public List<Dialog> listDialog(Long userId, Integer page, Integer size) {
    List<Dialog> dialogByUserId = dialogRepository.getDialogByUserId(userId,
        PageRequest.of(page, size));
    return dialogByUserId;
  }
}
