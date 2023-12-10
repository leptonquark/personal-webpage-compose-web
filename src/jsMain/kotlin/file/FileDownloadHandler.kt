package file

import html.HtmlAttribute
import html.HtmlElement
import kotlinx.browser.document
import kotlinx.dom.createElement
import org.w3c.dom.Document
import org.w3c.dom.HTMLAnchorElement

class FileDownloadHandler {
    fun download(path: String) {
        document.createDownloadAnchorElement(path).click()
    }

    private fun Document.createDownloadAnchorElement(path: String) = createElement(HtmlElement.ANCHOR) {
        setAttribute(HtmlAttribute.HREF, path)
        setAttribute(HtmlAttribute.DOWNLOAD, "")
    } as HTMLAnchorElement
}
