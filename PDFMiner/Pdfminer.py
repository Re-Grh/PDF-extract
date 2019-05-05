#!/usr/bin/env python  
# encoding: utf-8  
""" 
@author: GrH 
@contact: 1271013391@qq.com 
@file: Pdfminer.py 
@time: 2018/4/5 0005 22:47 
"""

# -*- coding: utf-8 -*-
import webbrowser
import importlib
import sys          #open
import logging
import os
logging.Logger.propagate = False
logging.getLogger().setLevel(logging.ERROR)
from pdfminer.converter import PDFPageAggregator
from pdfminer.layout import LTTextBoxHorizontal, LAParams
from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter,PDFTextExtractionNotAllowed
from pdfminer.pdfparser import PDFParser, PDFDocument
os.chdir(r'C:\Users\Administrator\Desktop')
from urllib.request import urlopen
'''
 解析pdf 文本，保存到txt文件中
'''
importlib.reload(sys)


def parse(_path):
    fp = open(_path, 'rb')  # rb以二进制读模式打开本地pdf文件
    # fp = urlopen(_path)  #打开在线PDF文档

    # 用文件对象来创建一个pdf文档分析器
    praser_pdf = PDFParser(fp)

    # 创建一个PDF文档
    doc = PDFDocument()

    # 连接分析器 与文档对象
    praser_pdf.set_document(doc)
    doc.set_parser(praser_pdf)

    # 提供初始化密码doc.initialize("123456")
    # 如果没有密码 就创建一个空的字符串
    doc.initialize()

    # 检测文档是否提供txt转换，不提供就忽略
    if not doc.is_extractable:
        raise PDFTextExtractionNotAllowed
    else:
        # 创建PDf资源管理器 来管理共享资源
        rsrcmgr = PDFResourceManager()

        # 创建一个PDF参数分析器
        laparams = LAParams()

        # 创建聚合器
        device = PDFPageAggregator(rsrcmgr, laparams=laparams)

        # 创建一个PDF页面解释器对象
        interpreter = PDFPageInterpreter(rsrcmgr, device)
        # 循环遍历列表，每次处理一页的内容
        # doc.get_pages() 获取page列表
        for page in doc.get_pages():
            # 使用页面解释器来读取
            interpreter.process_page(page)

            # 使用聚合器获取内容
            layout = device.get_result()
            # 这里layout是一个LTPage对象
            for out in layout:
                if isinstance(out, LTTextBoxHorizontal):
                    results = out.get_text()
                    # print(out.get_writing_mode())
                    # print("results: " + results)
                    # with open('test.txt', 'ab') as f:
                    #     f.write((results+'\r\n').encode('utf-8'))
                    with open('new.html', 'ab') as f:
                        f.write((results+'</br>').encode('utf-8'))

if __name__ == '__main__':
    path = "assignment3.pdf"
    # path = "http://pythonscraping.com/pages/warandpeace/chapter1.pdf"
    parse(path)
    webbrowser.open('new.html', new=1)

