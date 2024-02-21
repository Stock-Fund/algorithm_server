import subprocess
import os
import shutil

def run_protoc_command(proto_file, proto_type , output_directory):
    command = ['protoc', f'--{proto_type}={output_directory}', proto_file]
    subprocess.run(command)

def copy_files(source_dir, destination_dir):
    shutil.copy2(source_dir, destination_dir)

def copy_tree(source_dir, destination_dir):
    if os.path.exists(destination_dir):
        shutil.rmtree(destination_dir)
    shutil.copytree(source_dir, destination_dir)

# 调用函数并传入相应的参数
proto_file = 'algorithm.proto'
output_java_directory = './java/'
output_python_directory = './python/'
java_type = 'java_out'
python_type = 'python_out'
run_protoc_command(proto_file, java_type,output_java_directory)
run_protoc_command(proto_file, python_type,output_python_directory)

source = "/Users/gxm/workspace/Gradle/MyGradle/src/main/java/org/example/socket/proto/python/"
destionation = "/Users/gxm/workspace/XCrawler/src/socket/proto/"
copy_tree(source, destionation)