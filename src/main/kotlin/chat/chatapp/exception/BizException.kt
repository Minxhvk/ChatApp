package chat.chatapp.exception


class BizException(val baseResponseCode: BizResponseCode): RuntimeException() {
}