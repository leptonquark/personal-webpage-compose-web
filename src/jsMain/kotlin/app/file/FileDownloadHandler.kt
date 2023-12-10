package app.file

import app.html.HtmlAttribute
import app.html.HtmlElement
import kotlinx.browser.document
import kotlinx.dom.createElement
import org.koin.core.annotation.Single
import org.w3c.dom.Document
import org.w3c.dom.HTMLAnchorElement

@Single
class FileDownloadHandler {
    fun download(path: String) {
        document.createDownloadAnchorElement(path).click()
    }

    private fun Document.createDownloadAnchorElement(path: String) = createElement(HtmlElement.ANCHOR) {
        setAttribute(HtmlAttribute.HREF, path)
        setAttribute(HtmlAttribute.DOWNLOAD, "")
    } as HTMLAnchorElement
}
